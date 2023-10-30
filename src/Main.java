import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {

        int qtd = 2;
        int idx = 0;
        int[] numbers = new int[qtd];

        for (idx = 0;idx<qtd;idx++){
            int number = LerDados(idx+1);
            numbers[idx] = number;
        }
        Calculator calc = new Calculator(numbers[0],numbers[1]);

        String final_msg =  "Números : "+numbers[0]+" e "+numbers[1]+"\n"+
                            "Potência: "+Double.toString(calc.calculatePower())+"\n"+
                            "Quociente: "+Double.toString(calc.calculateQuotient());
        JOptionPane.showMessageDialog(null,final_msg);
    }

    public static int LerDados(int idx) throws Exception {

        String text = "as";
        boolean isNumeric = false;
        int num = 0;
        int i = 0;
        String error_msg = "O VALOR INSERIDO NÃO ERA VÁLIDO.";

        while (!isNumeric && i<3){
            i++;
            text = JOptionPane.showInputDialog(null, "Digite o "+idx+"º número");
            isNumeric = ChecarNumerico(text);
            if(!isNumeric && i<3){
                JOptionPane.showMessageDialog(null,error_msg);
            }

        }

        if (!isNumeric){
            JOptionPane.showMessageDialog(null,error_msg);
            throw new Exception(error_msg);
        } else {
            num = Integer.parseInt(text);
        }

        return num;
    }

    public static boolean ChecarNumerico(String text) {
        int num;

        if(text == null){
            return false;
        }

        try {
            num = Integer.parseInt(text);
            return true;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }

    }
}
