package Weather;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner             = new Scanner(System.in);
        String[][] dataTraining     = new String[6][4];
        int totalData1              = 0;
        int totalData2              = 0;

        //=============================== Insert Data Training =================================//
        System.out.println("Masukkan data training");
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                dataTraining[i][j] = scanner.next();
            }
        }

        for (int i = 0; i < 6; i++)
        {
            if(dataTraining[i][3].equalsIgnoreCase("Ya"))
            {
                totalData1 += 1;
            }
        }

        for (int i = 0; i < 6; i++)
        {
            if(dataTraining[i][3].equalsIgnoreCase("Tidak"))
            {
                totalData2 += 1;
            }
        }

        //=============================== Classification Data Training =================================//
        String[][] dataClassification1  = new String[totalData1][4];
        String[][] dataClassification2  = new String[totalData2][4];
        int row1                        = 0;
        int row2                        = 0;
        for (int i = 0; i < 6; i++)
        {
            if(dataTraining[i][3].equalsIgnoreCase("Ya"))
            {
                for (int j = 0; j < 4; j++)
                {
                    dataClassification1[row1][j] = dataTraining[i][j];
                }
                row1++;
            }
        }

        for (int i = 0; i < 6; i++)
        {
            if(dataTraining[i][3].equalsIgnoreCase("Tidak"))
            {
                for (int j = 0; j < 4; j++)
                {
                    dataClassification2[row2][j] = dataTraining[i][j];
                }
                row2++;
            }
        }

        //=============================== Create Log Classification Data Training =================================//
        try
        {
            PrintWriter printWriter1 = new PrintWriter("Data-Classification-Weather-1.txt", "UTF-8");
            PrintWriter printWriter2 = new PrintWriter("Data-Classification-Weather-2.txt", "UTF-8");
            for (int i = 0; i < totalData1; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    printWriter1.print(dataClassification1[i][j]+" ");
                }
                printWriter1.println(" ");
            }
            printWriter1.close();

            for (int i = 0; i < totalData2; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    printWriter2.print(dataClassification2[i][j]+" ");
                }
                printWriter2.println(" ");
            }
            printWriter2.close();
        }
        catch (IOException e)
        {
            System.err.println("Stack Trace: "+e);
        }

        //=============================== Create Hipotesa =================================//
        String[][] hipotesa1 = new String[1][4];
        String[][] hipotesa2 = new String[1][4];

        for (int i = 0; i < totalData1; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (i == 0)
                {
                    hipotesa1[0][j] = dataClassification1[i][j];
                }
                else
                {
                    if (hipotesa1[0][j].equals(String.valueOf(dataClassification1[i][j])))
                    {
                        hipotesa1[0][j] = String.valueOf(dataClassification1[i][j]);
                    }
                    else
                    {
                        hipotesa1[0][j] = "*";
                    }
                }
            }
        }

        for (int i = 0; i < totalData2; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (i == 0)
                {
                    hipotesa2[0][j] = dataClassification2[i][j];
                }
                else
                {
                    if (hipotesa2[0][j].equals(String.valueOf(dataClassification2[i][j])))
                    {
                        hipotesa2[0][j] = String.valueOf(dataClassification2[i][j]);
                    }
                    else
                    {
                        hipotesa2[0][j] = "*";
                    }
                }
            }
        }


        //=============================== Create Log Hipotesa =================================//
        try
        {
            PrintWriter printWriter1 = new PrintWriter("Hipotesa 1.txt","UTF-8");
            PrintWriter printWriter2 = new PrintWriter("Hipotesa 2.txt","UTF-8");
            System.out.println(" ");

            System.out.println("Hipotesa yang terbentuk");
            for (int i = 0; i < 4; i++)
            {
                System.out.print(hipotesa1[0][i]+" ");
                printWriter1.write(hipotesa1[0][i]+" ");
            }
            printWriter1.close();
            System.out.println(" ");
            for (int i = 0; i < 4; i++)
            {
                System.out.print(hipotesa2[0][i]+" ");
                printWriter2.write(hipotesa2[0][i]+" ");
            }
            printWriter2.close();
            System.out.println(" ");
        }
        catch (IOException e)
        {
            System.err.println("Stack Trace: "+e);
        }

        //=============================== Uji Hipotesa =================================//
        String[][] ujiHipotesa  = new String[1][3];
        int scoreHipotesa1      = 0;
        int scoreHipotesa2      = 0;

        System.out.println(" ");
        System.out.println("Masukkan data uji hipotesa (Apabila kosong isikan dengan -): ");

        for (int i = 0; i < 3; i++)
        {
            ujiHipotesa[0][i] = scanner.next();
        }

        for (int i = 0; i < 3; i++)
        {
            if(!hipotesa1[0][i].equals("*") && !hipotesa2[0][i].equals("*"))
            {
                if(ujiHipotesa[0][i].equals(hipotesa1[0][i]))
                {
                    scoreHipotesa1 += 1;
                }
                if(ujiHipotesa[0][i].equals(hipotesa2[0][i]))
                {
                    scoreHipotesa2 += 1;
                }
            }
        }

        if (scoreHipotesa1 > scoreHipotesa2)
        {
            System.out.println("Ya");
        }
        else
        {
            if(scoreHipotesa1 < scoreHipotesa2)
            {
                System.out.println("Tidak");
            }
            else
            {
                System.out.println("Data training dibutuhkan");
            }
        }
    }
}
