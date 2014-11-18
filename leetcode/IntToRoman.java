import java.util.*;
public class IntToRoman {
	//**************Solution1 arrays to store ahead of time********************//
	private static final String[] thousands = new String[]{"", "M", "MM", "MMM"};
	private static final String[] hundreds = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	private static final String[] tens = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	private static final String[] digits = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	public String intToRoman1(int num){
		assert num<=3999 && num >= 1;
		
        StringBuilder sb = new StringBuilder();
        sb.append(thousands[num/1000]);
        num%=1000;
        sb.append(hundreds[num/100]);
        num%=100;
        sb.append(tens[num/10]);
        num%=10;
        sb.append(digits[num]);
        
        return sb.toString();
	}
	
	//**************Solution2 char array to keep roman literals********************//
	private static final char[] romanLiterals = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};	
	public String intToRoman2(int num){
		String roman = "";
		for(int base = 0; num > 0; base+=2, num/= 10){
			int digit = num%10;
			switch(digit){
			case 1: case 2: case 3:
				String str1 = "";
				for(int i = digit; i > 0; i--){
					str1 += romanLiterals[base];
				}
				roman = str1+roman;
				break;
			case 4:
				roman = romanLiterals[base+1] + roman;
				roman = romanLiterals[base] + roman;
				break;
			case 5:
				roman = romanLiterals[base+1] + roman;
				break;
			case 6: case 7: case 8:
				String str2 = "";
				for(int i = digit-5; i > 0; i--){
					str2 +=  romanLiterals[base];
				}
				roman = romanLiterals[base+1] + str2 + roman;
				break;
			case 9:
				roman = romanLiterals[base+2] + roman;
				roman = romanLiterals[base] + roman;
				break;
			default:
				break;
			}
		}
		
		return roman;
	}
	
	//Store the correspondence between critical number and roman literals
    public String intToRoman3(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] literals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length && num > 0; i++){
            int occurrences = num/nums[i];
            num = num - occurrences*nums[i];
            while(occurrences > 0){
                sb.append(literals[i]);
                occurrences--;
            }
        }
        
        return new String(sb);
    }
	
	
	//***************Solutions 3 hashmap***********************//
	private static final Map<Integer,Character> romanMap = new HashMap<Integer,Character>();
    static{
        romanMap.put(1, 'I');
        romanMap.put(5, 'V');
        romanMap.put(10, 'X');
        romanMap.put(50, 'L');
        romanMap.put(100, 'C');
        romanMap.put(500, 'D');
        romanMap.put(1000, 'M');
    }    
    public String intToRoman(int num) {
        assert num<4000;
        
        StringBuilder roman = new StringBuilder();
        int div = 1000;
        while(num>0){
            int digit = num/div;
            roman.append(getRomanLiteral(digit, div));
            num %= div;
            div /= 10;
        }      
        return new String(roman);
    }    
    private String getRomanLiteral(int digit, int div){
        StringBuilder literals = new StringBuilder();
        char c, next;
        switch(digit){
            case 1: case 2: case 3:
                c = romanMap.get(div);
                for(int i=digit; i>0; i--){
                    literals.append(c);
                }
                break;
            case 4:
                c = romanMap.get(div);
                next = romanMap.get(div*5);
                literals.append(c).append(next);
                break;
            case 5:
                c = romanMap.get(div*5);
                literals.append(c);
                break;
            case 6: case 7: case 8:
                c = romanMap.get(div);
                next = romanMap.get(div*5);
                literals.append(next);
                for(int i=digit-5; i>0; i--){
                    literals.append(c);
                }
                break;
            case 9:
                c = romanMap.get(div);
                next = romanMap.get(div*10);
                literals.append(c).append(next);
                break;
            default:
                break;
        }
        return new String(literals);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
