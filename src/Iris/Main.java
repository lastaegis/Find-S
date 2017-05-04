package Iris;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[][] dataTraining      = new float[150][5];

        int jumlahData1             = 0;
        int jumlahData2             = 0;
        int jumlahData3             = 0;

        //======================== Insert Data Training Below This Line ======================//
        System.out.println("Masukkan Data Training: ");
        for (int i = 0; i < 150; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                dataTraining[i][j] = scanner.nextFloat();
            }
        }

        for (int i = 0; i < 150; i++)
        {
            if (dataTraining[i][4] == 1.0)
            {
                jumlahData1 += 1;
            }

            if (dataTraining[i][4] == 2.0)
            {
                jumlahData2 += 1;
            }

            if (dataTraining[i][4] == 3.0)
            {
                jumlahData3 += 1;
            }
        }

        //======================== Classification Result Below This Line ======================//
        float[][] classification1   = new float[jumlahData1][5];
        float[][] classification2   = new float[jumlahData2][5];
        float[][] classification3   = new float[jumlahData3][5];
        int row1                    = 0;
        int row2                    = 0;
        int row3                    = 0;

        for (int i = 0; i < 150; i++)
        {
            if (dataTraining[i][4] == 1.0)
            {
                for (int k = 0; k < 5; k++)
                {
                    classification1[row1][k] = dataTraining[i][k];
                }
                row1++;
            }
        }

        for (int i = 0; i < 150; i++)
        {
            if (dataTraining[i][4] == 2.0)
            {
                for (int k = 0; k < 5; k++)
                {
                    classification2[row2][k] = dataTraining[i][k];
                }
                row2++;
            }
        }

        for (int i = 0; i < 150; i++)
        {
            if (dataTraining[i][4] == 3.0)
            {
                for (int k = 0; k < 5; k++)
                {
                    classification3[row3][k] = dataTraining[i][k];
                }
                row3++;
            }
        }

        //======================== Create Log Classification Data in TXT======================//
        try
        {
            PrintWriter printWriter1 = new PrintWriter("Classification-1.txt","UTF-8");
            PrintWriter printWriter2 = new PrintWriter("Classification-2.txt","UTF-8");
            PrintWriter printWriter3 = new PrintWriter("Classification-3.txt","UTF-8");
            for (int i = 0; i < jumlahData1; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    printWriter1.print(classification1[i][j]+" ");
                }
                printWriter1.println(" ");
            }
            printWriter1.close();

            for (int i = 0; i < jumlahData2; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    printWriter2.print(classification2[i][j]+" ");
                }
                printWriter2.println(" ");
            }
            printWriter2.close();

            for (int i = 0; i < jumlahData3; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    printWriter3.print(classification3[i][j]+" ");
                }
                printWriter3.println(" ");
            }
            printWriter3.close();
        }
        catch (IOException e)
        {
            System.err.println("Stack Trace: "+e);
        }

        //======================== Training Below This Line ======================//
        String[][] trainingResult1   = new String[1][5];
        String[][] trainingResult2   = new String[1][5];
        String[][] trainingResult3   = new String[1][5];

        for (int i = 0; i < jumlahData1; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (i == 0)
                {
                    trainingResult1[0][j] = String.valueOf(classification1[i][j]);
                }
                else
                {
                    if (trainingResult1[0][j].equals(String.valueOf(classification1[i][j])))
                    {
                        trainingResult1[0][j] = String.valueOf(classification1[i][j]);
                    }
                    else
                    {
                        trainingResult1[0][j] = "*";
                    }
                }
            }
        }

        for (int i = 0; i < jumlahData2; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (i == 0)
                {
                    trainingResult2[0][j] = String.valueOf(classification2[i][j]);
                }
                else
                {
                    if (trainingResult2[0][j].equals(String.valueOf(classification2[i][j])))
                    {
                        trainingResult2[0][j] = String.valueOf(classification2[i][j]);
                    }
                    else
                    {
                        trainingResult2[0][j] = "*";
                    }
                }
            }
        }

        for (int i = 0; i < jumlahData3; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (i == 0)
                {
                    trainingResult3[0][j] = String.valueOf(classification3[i][j]);
                }
                else
                {
                    if (trainingResult3[0][j].equals(String.valueOf(classification3[i][j])))
                    {
                        trainingResult3[0][j] = String.valueOf(classification3[i][j]);
                    }
                    else
                    {
                        trainingResult3[0][j] = "*";
                    }
                }
            }
        }

        //======================== Create Log Training Result in TXT ======================//
        try
        {
            PrintWriter printWriter1 = new PrintWriter("Training-1.txt","UTF-8");
            PrintWriter printWriter2 = new PrintWriter("Training-2.txt","UTF-8");
            PrintWriter printWriter3 = new PrintWriter("Training-3.txt","UTF-8");
            for (int i = 0; i < 5; i++)
            {
                printWriter1.write(trainingResult1[0][i]+" ");
            }
            printWriter1.close();

            for (int i = 0; i < 5; i++)
            {
                printWriter2.write(trainingResult2[0][i]+" ");
            }
            printWriter2.close();

            for (int i = 0; i < 5; i++)
            {
                printWriter3.write(trainingResult3[0][i]+" ");
            }
            printWriter3.close();
        }
        catch (IOException e)
        {
            System.err.println("Stack Trace: "+e);
        }
    }
}
