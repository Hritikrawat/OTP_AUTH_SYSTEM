import axios from "axios";
import { useState } from "react";

function VerifyOtp(){
const [otp,setOtp] = useState('');

const verify = async()=> {
      
    const mobile = sessionStorage.getItem("mobile");

    const reponse = await axios.post(`http://localhost:8081/otp/verifyOtp `,
        {
            mobile,
            otp
        }
    )
    if(reponse.status==200 && reponse.data==="Verified")
           {
                alert("Verfied");
           } 
    else 
           alert("Wrong OTP")

}

return (
    <div className="mainDiv">
        <input type="tel"
            maxLength='6'
            // value={otp}
            onChange={(e)=> {setOtp(e.target.value)}}
            placeholder="Enter 6-Digit Otp"
            style={{ fontSize: "16px", padding: "8px", width: "150px", textAlign: "center" }}
        />
        <button 
            onClick={verify}
            style={{ padding: "5px 10px" }}
        >
            Verify Otp </button>
    </div>
    
    
)

}

export default VerifyOtp;