class Solution {
    

    public int numSteps(String s) {
        
        int step = 0;
        int carry = 0;
        
        for (int i = s.length() - 1; i > 0; i--) {
            // i>0 i 1 pr hi ruk jayga 0 tk nhi jayga taki jb hum divide krte h tho binary mai divide krne ka matlab hota h ek bit hata dena tho jb last pr aajyge tho hatane k liye kuch ho isliye 1 bit phel ehi ruk jata h loop
            int bit = (s.charAt(i) - '0') + carry;

            //agr bit 1 h tho odd -> phele add1 fir divide  total 2 step
            if (bit == 1) {
                step += 2;
                carry = 1;// add kr rhe tho carry bdh gyi
            } else {
                step += 1;//number even h bss add 1 kro -> step ek hi bdhegi
            }
        }
        return step + carry;// kitni step hui or akhri wali carry 

    }
}

