import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[][] dataTraining      = new float[150][5];
        float[][] hipotesa          = new float[15][5];

        int jumlahData1             = 0;
        int jumlahData2             = 0;
        int jumlahData3             = 0;

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
        float[][] trainingResult1   = new float[jumlahData1][5];
        float[][] trainingResult2   = new float[jumlahData2][5];
        float[][] trainingResult3   = new float[jumlahData3][5];

        for (int i = 0; i < 150; i++)
        {
            if (dataTraining[i][4] == 1.0)
            {
                for (int j = 0; j < jumlahData1; j++)
                {
                    for (int k = 0; k < 5; k++)
                    {
                        trainingResult1[j][k] = dataTraining[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < 150; i++)
        {
            if (dataTraining[i][4] == 2.0)
            {
                for (int j = 0; j < jumlahData2; j++)
                {
                    for (int k = 0; k < 5; k++)
                    {
                        trainingResult2[j][k] = dataTraining[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < 150; i++)
        {
            if (dataTraining[i][4] == 3.0)
            {
                for (int j = 0; j < jumlahData3; j++)
                {
                    for (int k = 0; k < 5; k++)
                    {
                        trainingResult3[j][k] = dataTraining[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < jumlahData2; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                System.out.print(trainingResult3[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
