import {createClient} from '@supabase/supabase-js'

//lol for this only VITE key only i have to waste my  1hours to find why tthe url and key is undefined
const url = import.meta.env.VITE_SUPABASE_URL
const key = import.meta.env.VITE_SUPABASE_KEY

if (!url || !key) {
  console.error('❌ Supabase environment variables are missing');
}

const Supabase = createClient(url,key)

export default Supabase
