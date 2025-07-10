import Supabase from './SupabaseClient.jsx'
import { useState } from 'react';
import VerifyOtp from './VerifyOtp.jsx';
import axios from 'axios';
import './Input.css'

function Input() {

  const [num, setNum] = useState('')
  const [inputVal, steInputVal] = useState('')
  const [loading, setLoading] = useState(false);
  const[otpSent,setotpSent] = useState(false);


  const onSubmit = async () => {
    const mobile = inputVal.trim()
    sessionStorage.setItem("mobile",mobile);

    if (mobile === "") {
      alert("❗ Please enter a mobile number");
      return;
    }
    const API = `http://localhost:8080/user/generate?P_no=${inputVal}`;
    setLoading(true);

    try {
      const response = await axios.post(API);

      if (response.status == 200)
        alert(response.data)
      setotpSent(true)
      setLoading(false)
    }

    catch (e) {
      alert("Error sending OTP", e.message);
      setLoading(false)
    }

    // const { error } = await Supabase
    //   .from("Mobiles")
    //   .insert({ 'mobile': inputVal })
    //   .single();


    // if (error) {
    //   console.error("Error while adding tasks : ", error.message)
    // }
    // else {
    //   setNum(inputVal);
    //   console.log("Inserted")
    // }
  };

  return (
    <div className='mainDiv'>
      {otpSent?<VerifyOtp/>:(<><input
        type='text'
        maxLength='10'
        value={inputVal}
        onChange={(e) => { steInputVal(e.target.value) }}
        placeholder='Enter Number'
      />

      <br />

      <button onClick={onSubmit} disabled={loading}>
        {loading ? "Sending..." : "Generate OTP"}
      </button>
      {loading && <div className="spinner"></div>}

</>)}
    </div>
  )
}

export default Input;
