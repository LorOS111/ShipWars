
public class SimpleDotCome{
    private int[] locationCells = new int[3];
    private int numOfHits = 0;
    public void setLocationCells(int[] locationCells) {
        this.locationCells = locationCells;
    }
    public String checkYourself(int guess){
        String result = "Промазал";
        for (int i = 0; i < locationCells.length && result.equals("Промазал"); i++) {
            if (guess==locationCells[i]){
                numOfHits++;
                result = "Попал";
            }
        }
        if (numOfHits==locationCells.length){
            result = "Потопил";
        }
        return result;
    }
}
class SimpleDotComTestDrive {
    public static void main(String[] args) {
        SimpleDotCome simpleDotCome = new SimpleDotCome();
        int[] location = {2,3,4};
        simpleDotCome.setLocationCells(location);
        boolean doesItWork = false;
        String result = "";
        for (int i = 0; i < 5; i++) {
            String results;
            results = simpleDotCome.checkYourself(i);
            result += results;
            System.out.println(result);
        }
        if (result.equals("ПромазалПромазалПопалПопалПотопил")){
            doesItWork = true;
        }
        System.out.println(doesItWork);
    }
}//Это тест для проверки методов SimpleDotCome