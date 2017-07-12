public class GlobalMembersAlog2
{
	//C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
	//ORIGINAL LINE: #define banillim(x, dig) (floor((x) * pow(10, dig) + 0.5) / pow(10,dig))

	public static int m = 4;
	public static int n = 4;
	public static int r = 4;
	public static int i = 0;
	public static int j = 0;
	public static int s = 0;
	public static int h = 0;
	public static int l = 0;
	public static int[][] matrix =
	{
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
	};
	public static int[][] finalMatrix =
	{
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
	};
	public static duv_st dss = new duv_st();

	public static int printMatrix()
	{
		System.out.print("printed...\n");
		for (h = 1; h <= n; h++)
		{
			for (s = 1; s <= m; s++)
			{
				System.out.printf("%d\t", matrix[h][s]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		return 0;
	}

	public static int myFloor(int a_ij, int b) //a_ij=matrix[i][j]
	{
		int q;
		if ((a_ij / b) >= 0) //����� 0�̸� �׳� floor���
		{
			q = Math.floor((a_ij / b)); //�Ҽ��� ���� �� ����
		}
		else //�׿��� ������ ��
		{
			q = Math.ceil((-1) * (a_ij / b)); //4, �Ҽ��� ���ϸ� �� �ø�
			q = (-1) * q; //-3.2
		}
		return q;
	}

	//����
	public static int myfloor(int a_ij, float b) //a_ij=matrix[i][j]
	{
		float q;

		q = (float)Math.floor((a_ij / b)); //�Ҽ��� ���� �� ����

		return q;
	}

	//����
	public static int gcd(int a_ij, int b_ij)
	{
		if (a_ij < b_ij)
		{
			int tmp = a_ij;
			a_ij = b_ij;
			b_ij = tmp;
		}

		int mod = a_ij % b_ij;
		if (mod == 0)
		{
			return b_ij;
		}
		else
		{
			return gcd(b_ij, mod);
		}
	}

	//����
	public static duv_st compute(int d, int u, int v)
	{
		//compute(d,u,v)->d = u*(matrix[l][s]) + v*(matrix[h][s]) = gcd(matrix[l][s], matrix[h][s])
		System.out.print("I'm in compute\n");

		for (h = 1; h <= 4; h++) //1~4 column
		{
			for (s = 1; s <= 4; s++) //1~4 row
			{
				for (l = 1; l <= 4; l++)
				{
					d == gcd(matrix[l][s], matrix[h][s]);
					u * (matrix[l][s]) + v * (matrix[h][s]) == d;
				}
			}
		}
		duv_st dss = new duv_st();
		dss.d = d;
		dss.u = u;
		dss.v = v;
		return dss;
	}

	public static int Main()
	{
		FILE in_file;

		fopen_s(in_file, "input.txt", "r");
		if (in_file == null)
		{
			System.out.print("file open x");
			System.exit(1);
		}

		fscanf_s(in_file, "%d %d", m, n);
		for (s = 1; s <= n; s++)
		{
			for (h = 1; h <= m; h++)
			{
				fscanf_s(in_file, "%d", matrix[s][h]);
			}
		}

		//�ʱ� ��Ʈ���� ���
		System.out.print("Before\n");
		printMatrix();

		//����
		int[][] vector =
		{
			{0}
		};
		int k = 1;
		int d = 2;
		int u = 0;
		int v = -1;
		int b = 1;
		int q = 0;
		int row;
		int x;
		int leading = 0;
		int min = 1000;
		for (j = 1; j <= n; j++)
		{
			for (i = 1; i <= m; i++)
			{
				System.out.printf("\n=====================j=%d started======================\n", j);
				System.out.print("\nI'm in main()\n");

				if (!matrix[j][i] == 0)
				{
					System.out.print("\nI'm in main_compute()\n");
					compute(d, u, v);
					vector[j][k] = u * matrix[j][k] + v * matrix[j][i];
					matrix[j][i] = (matrix[j][k] / d) * matrix[j][i] - (matrix[j][i] / d) * matrix[j][k];
					matrix[j][k] = vector[j][k];
				}

				min = 1000;
				for (x = k; x <= n; x++) //n�� �����̴ϱ� ������.
				{
					if ((Math.abs(min) > Math.abs(matrix[x][j])) && matrix[x][j] != 0)
					{
						min = matrix[x][j]; //�� j���� ������ ���� ���� entry ���� & (leading���� ��ü�� ���̹Ƿ�)entry�� 0�� �ƴ�
						row = x;
					}
					printMatrix(); //����
				}

				//printf("row=%d min=%d\n", row, min);

				int temp = 0;
				if (row >= k) //���� �۾Ҵ� row���� K���� ū��� -> �̸� k(�밢����)
				{
					temp = matrix[k][1];
					matrix[k][1] = matrix[row][1];
					matrix[row][1] = temp;

					temp = matrix[k][2];
					matrix[k][2] = matrix[row][2];
					matrix[row][2] = temp;

					temp = matrix[k][3];
					matrix[k][3] = matrix[row][3];
					matrix[row][3] = temp;

					temp = matrix[k][4];
					matrix[k][4] = matrix[row][4];
					matrix[row][4] = temp;

					if (matrix[k][j] < 0) //�밢������� 0���� ���� ���, ����� �������.
					{
						matrix[k][1] = (-1) * matrix[k][1];
						matrix[k][2] = (-1) * matrix[k][2];
						matrix[k][3] = (-1) * matrix[k][3];
						matrix[k][4] = (-1) * matrix[k][4];
					}
				}


				//Reduced Rows
				b = matrix[k][j];


				for (i = (k + 1); i <= n; i++) //K�� �Ʒ����� reduction ����
				{

					if (matrix[i][j] != 0)
					{
						if (b == 0)
						{
							q = (Math.floor((matrix[i][j]) * Math.pow(10, 0.1) + 0.5) / Math.pow(10,0.1));
							System.out.print("\nb is zero\n");
							//continue;
						}
						else
						{
							q = matrix[i][j] / b;
						}


						matrix[i][j] = matrix[i][j] - (q * matrix[k][j]);
						matrix[i][j + 1] = matrix[i][j + 1] - (q * matrix[k][j + 1]);
						matrix[i][j + 2] = matrix[i][j + 2] - (q * matrix[k][j + 2]);
						matrix[i][j + 3] = matrix[i][j + 3] - (q * matrix[k][j + 3]);
					}
				}
			}
			k++;
		}

		System.out.print("\nupper triangular position\n");
		printMatrix();

		//Final Reductions
		k = 1;
		for (j = 1; j <= n; j++)
		{
			System.out.printf("\n===================j=%d started===================\n", j);
			if (matrix[k][j] < 0)
			{
				System.out.printf("\nb=%d i=%d k=%d j=%d q=%d matrix[i][j]=%d\n", b, i, k, j, q, matrix[i][j]); //����
				matrix[k][1] = (-1) * matrix[k][1];
				matrix[k][2] = (-1) * matrix[k][2];
				matrix[k][3] = (-1) * matrix[k][3];
				matrix[k][4] = (-1) * matrix[k][4];
			}
			System.out.print("if start\n");
			b = matrix[k][j];
			System.out.printf("\nb=%d\n", b); //����
			if (b == 0)
			{
				continue;
				System.out.print("\nb is zero\n");
			}
			else
			{
				for (i = 1; i <= (k - 1); i++)
				{
					q = myfloor(matrix[i][j], b); //����
					System.out.printf("\nb=%d i=%d k=%d j=%d q=%d matrix[i][j]=%d\n", b, i, k, j, q, matrix[i][j]);

					matrix[i][1] = matrix[i][1] - (q * matrix[k][1]);
					matrix[i][2] = matrix[i][2] - (q * matrix[k][2]);
					matrix[i][3] = matrix[i][3] - (q * matrix[k][3]);
					matrix[i][4] = matrix[i][4] - (q * matrix[k][4]);
					printMatrix();
				}
			}
			k++;
		}

		for (i = 1; i <= 4; i++)
		{
			for (j = 1; j <= 4; j++)
			{
				finalMatrix[i][j] = matrix[i][j];
			}
		}
		//���
		System.out.print("\nAfter\nprinted...\n");
		for (i = 1; i <= 4; i++)
		{
			for (j = 1; j <= 4; j++)
			{
				System.out.printf("%d\t", finalMatrix[i][j]);
			}
			System.out.print("\n");
		}
		fclose(in_file);
	}
}