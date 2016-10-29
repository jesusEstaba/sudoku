package sudoku;
//@author Rakzodia

import javax.swing.JOptionPane;
import sudoku.Inter;

public class Sudoku {
	public static int n=9;
    public static void main(String[] args){

    Inter Nomina = new Inter(); 
    Nomina.setVisible(true); 

//        int sudoku[][]=new int [9][9];
//        
//        sudoku[0][1]=1;
//        sudoku[0][2]=7;
//        sudoku[0][5]=3;
//        
//        sudoku[1][0]=5;
//        sudoku[1][2]=3;
//        sudoku[1][5]=1;
//        sudoku[1][6]=9;
//        sudoku[1][8]=6;
//        
//        sudoku[2][0]=9;
//        sudoku[2][3]=5;
//        sudoku[2][4]=2;
//        
//        sudoku[3][3]=8;
//        sudoku[3][6]=4;
//        sudoku[3][7]=2;
//        sudoku[3][8]=3;
//        
//        sudoku[4][0]=3;
//        sudoku[4][3]=2;
//        sudoku[4][5]=7;
//        sudoku[4][8]=5;
//        
//        sudoku[5][0]=2;
//        sudoku[5][1]=9;
//        sudoku[5][2]=5;
//        sudoku[5][5]=4;
//        
//        sudoku[6][4]=1;
//        sudoku[6][5]=2;
//        sudoku[6][8]=9;
//        
//        sudoku[7][0]=1;
//        sudoku[7][2]=9;
//        sudoku[7][3]=4;
//        sudoku[7][6]=6;
//        sudoku[7][8]=2;
//        
//        sudoku[8][3]=9;
//        sudoku[8][6]=5;
//        sudoku[8][7]=3;
//        
//        ImprimirMatriz(sudoku);
//        System.out.println();
//        System.out.println();
//        
//        
//        int band=Restantes(sudoku);
//        while(true)
//        {
//        
//        for(int i=0;i<9;i++)
//            for(int j=0;j<9;j++)
//		if(sudoku[i][j]==0)
//                    Asignacion(sudoku,i,j);
//        
//        
//        if(Restantes(sudoku)==band)
//            break;
//        band=Restantes(sudoku);
//        
//        }
//        
//        if(Restantes(sudoku)==0)
//        {
//            System.out.println("Sodoku Resuelto");
//            ImprimirMatriz(sudoku);
//        }
//        else
//        {
//            JOptionPane.showMessageDialog(null,  "Este sudoku no se puede Resolver","Irresoluble", JOptionPane.ERROR_MESSAGE);
//            System.out.println("Sodoku Hasta donde se pudo");
//            ImprimirMatriz(sudoku);
//        }
    }
    
    public static int Restantes(int array[][]){
        int cont=0;
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                if(array[i][j]==0)
                    cont++;
        return cont;
    }
    
    public static void ImprimirMatriz(int sudoku[][])
    {
        for(int i=0;i<9;i++)
	{
            for(int j=0;j<9;j++){
                if(j==2 || j==5)
                    System.out.print(sudoku[i][j]+"||");
                else
                    System.out.print(sudoku[i][j]+"|");
            }
            
            
            
            if(i==2 || i==5)
            {
                System.out.println();
                System.out.println("------------------");
            }
                else
                    
            
            System.out.println();
	}
    }
    
    
    
    
    
    public static void Asignacion(int arreglo[][],int fil,int col){
    	int Array1al9[]=new int [9];
    	for(int i=0;i<9;i++)
            Array1al9[i]=i+1;
        

    	Columna(arreglo,col,Array1al9);
    	Fila(arreglo,fil,Array1al9);
    	Matriz(arreglo,fil,col,Array1al9);
    	//System.out.println("Fila:"+(fil+1)+", Columna:"+(col+1));
    	int valor=Disponible(Array1al9);
    	if(valor>0)
        {
            arreglo[fil][col]=valor;
            //System.out.println("  +Aignado en Fila:"+(fil+1)+", Columna:"+(col+1)+"; Numero:"+valor);
        }
    }

	public static int Disponible(int array[]){
		int valor=0,cont=0,num=0;
		for(int i=0;i<9;i++)
			if(array[i]!=0){
                                //System.out.println("   Disponible:"+array[i]);
				num=array[i];
				cont++;
			}

		if(cont==1)
                    valor=num;
		
		return valor;
	}

    public static void Switch(int array[],int num){
    	switch(num){
    		case 1:array[0]=0;break;
    		case 2:array[1]=0;break;
    		case 3:array[2]=0;break;
    		case 4:array[3]=0;break;
    		case 5:array[4]=0;break;
    		case 6:array[5]=0;break;
    		case 7:array[6]=0;break;
    		case 8:array[7]=0;break;
    		case 9:array[8]=0;break;
    	}
    }

    public static void Fila(int arreglo[][],int fil,int Array1al9[]){
		for(int i=0;i<9;i++)
			if(arreglo[fil][i]!=0)
				Switch(Array1al9,arreglo[fil][i]);
	}

    public static void Columna( int arreglo[][],int col,int Array1al9[]){
		for(int i=0;i<9;i++)
			if(arreglo[i][col]!=0)
				Switch(Array1al9,arreglo[i][col]);
	}

	public static void Matriz(int array[][],int fil,int col,int Array1al9[]){
		//matriz 1
		if(col<=2 && fil<=2)
			matriz(0, 0,array,Array1al9);

		//matriz 2
		if(fil<=2 && col>=3 && col<=5)
			matriz(0, 3,array,Array1al9);

		//matriz 3
		if(fil<=2 && col>=6 && col<=8)
			matriz(0, 6,array,Array1al9);

		//matriz 4
		if(fil>=3 && fil<=5 && col<=2)
			matriz(3, 0,array,Array1al9);

		//matriz 5
		if(fil>=3 && fil<=5 && col>=3 && col<=5)
			matriz(3, 3,array,Array1al9);

		//matriz 6
		if(fil>=3 && fil<=5 && col>=6 && col<=8)
			matriz(3, 6,array,Array1al9);

		//matriz 7
		if(fil>=6 && fil<=8 && col<=2)
			matriz(6, 0,array,Array1al9);

		//matriz 8
		if(fil>=6 && fil<=8 && col>=3 && col<=5)
			matriz(6, 3,array,Array1al9);

		//matriz 9
		if(fil>=6 && fil<=8 && col>=6 && col<=8)
			matriz(6, 6,array,Array1al9);
	}
	
	public static void matriz( int fil,int col,int arreglo[][],int Array1al9[]){
		for(int i=fil;i<fil+3;i++)
			for(int j=col;j<col+3;j++)
				if(arreglo[i][j]!=0)
					Switch(Array1al9,arreglo[i][j]);
	}
    
}
