/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_tema.a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class TP_TemaA {

    public static void main(String[] args) {
        int opcao = -1;
        int opcao1 = -1;
        int opcao2 = -1;
        int opcao3 = -1;
        Scanner scanner = new Scanner(System.in);
        Cliente clientes[] = new Cliente[20];
        Veiculo[] veiculo = new Veiculo[50];
        Mecanico mecanicos[] = new Mecanico[50];
        Marcacao marcacao[] = new Marcacao[50];

        int IDmarcacao = 0;

        //Restaurar dados clientes
        try {
            int i = 0;
            File file = new File("Files/clientes.txt");

            if (file.exists()) {

                Scanner in = new Scanner(new FileReader("Files/clientes.txt"));
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    String[] Arr = line.split(",");

                    clientes[i] = new Cliente(Integer.parseInt(Arr[0]), Arr[1], Arr[2]);

                    i++;
                }
            } else {
                System.out.println("\t\tAINDA NÃO EXISTEM CLIENTES!\n\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Restaurar dados veiculos
        try {
            int i = 0;
            File file = new File("Files/veiculos.txt");

            if (file.exists()) {

                Scanner in = new Scanner(new FileReader("Files/veiculos.txt"));
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    String[] Arr = line.split(",");

                    veiculo[i] = new Veiculo(Integer.parseInt(Arr[0]), Arr[1], Integer.parseInt(Arr[2]));
                    i++;
                }
            } else {
                System.out.println("\t\tAINDA NÃO EXISTEM VEICULOS!\n\n"
                        + "");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //RESTAURAR DADOS DO MECANICO
        try {
            int i = 0;
            File file = new File("Files/mecanicos.txt");

            if (file.exists()) {

                Scanner in = new Scanner(new FileReader("Files/mecanicos.txt"));
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    String[] Arr = line.split(",");

                    mecanicos[i] = new Mecanico(Integer.parseInt(Arr[0]), Arr[1], Arr[2]);

                    i++;
                }
            } else {
                System.out.println("\t\tAINDA NÃO EXISTEM MECANICOS!\n\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Restaurar dados marcacao
        try {
            int i = 0;
            File file = new File("Files/marcacoes.txt");

            if (file.exists()) {

                Scanner in = new Scanner(new FileReader("Files/marcacoes.txt"));
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    String[] Arr = line.split(",") ;
                    //this.ID + "," + this.IDcliente + "," + this.numero + "," + this.estado + "," + this.TotalGasto;
                    marcacao[i] = new Marcacao();
                    marcacao[i].setID(Integer.parseInt(Arr[0]));
                    marcacao[i].setIDcliente(Integer.parseInt(Arr[1]));
                    marcacao[i].setNumero(Integer.parseInt(Arr[2]));
                    switch (Arr[3]) {
                        case "Aceitar":
                            marcacao[i].setEstado(Estado.Aceitar);
                            break;
                        case "Aceite":
                            marcacao[i].setEstado(Estado.Aceite);
                            break;
                        case "Nao_aceite":
                            marcacao[i].setEstado(Estado.Nao_aceite);
                            break;
                        case "Cancelada":
                            marcacao[i].setEstado(Estado.Cancelada);
                            break;
                        case "Em_tratamento":
                            marcacao[i].setEstado(Estado.Em_tratamento);
                            break;
                        case "Concluido":
                            marcacao[i].setEstado(Estado.Concluido);
                            break;
                        case "Entregue":
                            marcacao[i].setEstado(Estado.Entregue);
                            break;
                    }

                    marcacao[i].setTotalGasto(Arr[4]);
                    marcacao[i].setDescricao(Arr[5]);
                    
                    
                    i++;
                }
            } else {
                System.out.println("\t\tAINDA NÃO EXISTEM MARCAÇÕES1"
                        + "!\n\n"
                        + "");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // < < < < < MENU > > > > >
        do {
            System.out.println("\t\t < < < < < GESTÃO DE UMA OFICINA DE AUTOMOVEIS > > > > >\n ");
            System.out.println("\t\t1 - CLIENTES\n ");
            System.out.println("\t\t2 - GESTOR\n ");
            System.out.println("\t\t3 - MECANICO\n ");
            System.out.println("\t\t0 - SAIR\n\n");
            System.out.println("INSIRA A OPCAO: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    do {
                        System.out.println("\t\t < < < < < GESTÃO DE UMA OFICINA DE AUTOMOVEIS > > > > >\n ");
                        System.out.println("\t\t1 - INSERIR CLIENTE\n ");
                        System.out.println("\t\t2 - INSERIR VEICULO\n ");
                        System.out.println("\t\t3 - REALIZAR MARCAÇÃO\n ");
                        System.out.println("\t\t4 - LISTAR ESTADO DAS MARCAÇÕES\n ");
                        System.out.println("\t\t0 - SAIR\n\n");
                        System.out.println("INSIRA A OPCAO: ");
                        opcao1 = scanner.nextInt();

                        switch (opcao1) {
                            case 1:
                                Cliente cliTemp = inserirCliente(clientes);
                                for (int x = 0; x < clientes.length; x++) {
                                    if (clientes[x] == null) {
                                        clientes[x] = cliTemp;
                                        break;
                                    }

                                }
                                gravar(clientes, veiculo, mecanicos, marcacao);
                                
                                break;

                            case 2:
                                inserirVeiculo(veiculo);
                                gravar(clientes, veiculo, mecanicos, marcacao);
                                break;
                            case 3:
                              
                                       listarCliente(clientes);
                                       listarVeiculo(veiculo);
                                int m = 0;
                                for (Marcacao mTemp : marcacao) {
                                    if (mTemp != null) {
                                        m++;
                                    } else {
                                        break;
                                    }
                                }
                                marcacao[m] = realizarMarcacao(clientes, IDmarcacao);
                                IDmarcacao++;
                                gravar(clientes, veiculo, mecanicos, marcacao);
                                break;

                            case 4:
                                
                                  for (Marcacao mTemp : marcacao) {
                                    if (mTemp != null) {
                                            for (Cliente cTemp : clientes) {
                                                if (cTemp != null) {
                                                    if (mTemp.getIDcliente() == cTemp.getID()) {
                                                        System.out.println("\tID DO CLIENTE: " + mTemp.getIDcliente()+ " | " + "NOME DO CLIENTE: " + cTemp.getNome()+" | " + "NUMERO: " + mTemp.getNumero() +" | "+ "ESTADO: " + mTemp.getEstado() + "\n\n");
                                                        break;
                                                    }
                                                }
                                            }
            
                                        
                                    }
                                   

                                }
                                             
                                             
                                break;


                            case 0:
                                //gravar(clientes, veiculo,mecanicos);
                                opcao1 = 0;
                               

                                break;

                        }

                    } while (opcao1 != 0);

                    break;

                case 2:
                    do {
                        System.out.println("\t\t < < < < < GESTÃO DE UMA OFICINA DE AUTOMOVEIS > > > > >\n ");
                        System.out.println("\t\t1 - APROVAR MARCAÇÕES PARA O MECANICO\n ");
                        System.out.println("\t\t2 - INSERIR MECANICO\n ");
                        System.out.println("\t\t3 - LISTAR CLIENTE\n ");
                        System.out.println("\t\t4 - LISTAR MECANICOS\n ");
                        System.out.println("\t\t5 - DAR SAIDA DE UM VEICULO\n ");
                        System.out.println("\t\t0 - SAIR\n\n");
                        System.out.println("INSIRA A OPCAO: ");
                        opcao2 = scanner.nextInt();
                        switch (opcao2) {
                            case 1:
                                int i = 0;
                                for (Marcacao mTemp : marcacao) {
                                    if (mTemp != null) {
                                        if (mTemp.getEstado().equals(Estado.Aceitar)) {
                                           

                                            for (Cliente cTemp : clientes) {
                                                if (cTemp != null) {
                                                    if (mTemp.getIDcliente() == cTemp.getID()) {
                                                        System.out.println("\nNOME DO CLIENTE: " + cTemp.getNome());
                                                        System.out.println(i + " - " + "ID: " + mTemp.getID()+ " | " +"ID DO CLIENTE: " + mTemp.getIDcliente()+ " | "+ "NUMERO: " + mTemp.numero+ " | " + "ESTADO: " + mTemp.getEstado()+ " | " + "TOTAL GASTO: " + mTemp.getTotalGasto()+ " | " + "DESCRIÇÃO: " + mTemp.getDescricao());
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i++;

                                }
                                int op = 0; //opcao

                                Scanner scan = new Scanner(System.in);

                                System.out.println("\nINTRODUZA UMA OPÇÃO: ");
                                op = scan.nextInt();

                                
                                marcacao[op].setEstado(Estado.Aceite);
                                
                                gravar(clientes, veiculo, mecanicos, marcacao);
                                
                                break;

                            case 2:
                                Mecanico cliTempm = inserirMecanico(mecanicos);
                                for (int x = 0; x < mecanicos.length; x++) {
                                    if (mecanicos[x] == null) {
                                        mecanicos[x] = cliTempm;
                                        break;
                                    }

                                }
                                gravar(clientes, veiculo, mecanicos, marcacao);
                              
                                break;
                            case 3:
                                listarCliente(clientes);
                                break;
                                
                            case 4:
                                listarMecanicos(mecanicos);
                                break;
                            case 5:
                                   int l=0;
                                for (Marcacao mTemp : marcacao) {
                                    if (mTemp != null) {
                                        if (mTemp.getEstado().equals(Estado.Concluido)) {
                                          

                                            for (Cliente cTemp : clientes) {
                                                if (cTemp != null) {
                                                    if (mTemp.getIDcliente() == cTemp.getID()) {
                                                        System.out.println("\nNOME DO CLIENTE: " + cTemp.getNome());
                                                        System.out.println(l + " - " + "ID: " + mTemp.getID()+ " | " +"ID DO CLIENTE: " + mTemp.getIDcliente()+ " | "+ "NUMERO: " + mTemp.numero+ " | " + "ESTADO: " + mTemp.getEstado()+ " | " + "TOTAL GASTO: " + mTemp.getTotalGasto()+ " | " + "DESCRIÇÃO: " + mTemp.getDescricao());
                                                        break;
                                                    }
                                                }
                                            }
                                            
                                        }
                                    }
                                    l++;

                                }
                                 int oc = 0; //opcao
                                 String oi = "";
                                Scanner f = new Scanner(System.in);
                                
                                System.out.println("\nINTRODUZA UMA OPÇAO: ");
                                oc = f.nextInt();
                                f.nextLine();
                                
                               System.out.println("\nINTRODUZA O VALOR PAGO PELO CLIENTE: ");
                                oi = f.nextLine();
                               
                                marcacao[oc].setEstado(Estado.Entregue);
                                
                                System.out.println("\nVEICULO ENTREGUE! ");
                                 
                                 gravar(clientes, veiculo,mecanicos,marcacao);
                                
                                    break;
                                    
                            case 0:
                                //gravar(clientes, veiculo,mecanicos);
                                opcao2 = 0;
                                break;

                        }

                    } while (opcao2 != 0);

                    break;

                case 3:
                    do {
                        System.out.println("\t\t < < < < < GESTÃO DE UMA OFICINA DE AUTOMOVEIS > > > > >\n ");
                        System.out.println("\t\t1 - LISTAR MARCAÇÕES\n ");
                        System.out.println("\t\t2 - LISTAR INFORMAÇÕES RELATIVAS A MARCAÇÃO\n ");
                        System.out.println("\t\t3 - LISTAR VEICULOS\n ");
                        System.out.println("\t\t4 - REPARAÇÕES FEITAS NO VEICULO\n ");
                        System.out.println("\t\t5 - MUDAR O ESTADO DO VEICULO\n ");
                        System.out.println("\t\t0 - SAIR\n\n");
                        System.out.println("INSIRA A OPCAO: ");
                        opcao3 = scanner.nextInt();
                        switch (opcao3) {
                            case 1:
                                listarMarcacoes(marcacao);
                                break;

                            case 2:
                                int k=0;
                                for (Marcacao mTemp : marcacao) {
                                    if (mTemp != null) {
                                            for (Cliente cTemp : clientes) {
                                                if (cTemp != null) {
                                            for(Veiculo xTemp : veiculo){
                                                if ( xTemp != null){
                                                    if (mTemp.getIDcliente() == cTemp.getID()) {
                                                        System.out.println("\nNOME DO CLIENTE: " + cTemp.getNome());
                                                        System.out.println( "ID DO CLIENTE: " + mTemp.getIDcliente()+ " | "+ "NUMERO: " + mTemp.numero+ " | " + "ESTADO: " + mTemp.getEstado()+ " | " + "TOTAL GASTO: " + mTemp.getTotalGasto()+ " | " + "DESCRIÇÃO: " + mTemp.getDescricao());
                                                         System.out.println("MARCA: " + xTemp.getMarca() + " | " + "ANO: " + xTemp.getAno()+ "\n");
                                                        break;
                                                    }
                                                }
                                            }
                                          }
                                    }
                                            
                                        
                                    }
                                    //k++;

                                }
                                break;
                                
                            case 3:
                                listarVeiculo(veiculo);
                                break;

                                
                            case 4:
                                
                                int i=0;
                                for (Marcacao mTemp : marcacao) {
                                    if (mTemp != null) {
                                        if (mTemp.getEstado().equals(Estado.Aceite)) {
                                            

                                            for (Cliente cTemp : clientes) {
                                                if (cTemp != null) {
                                                    if (mTemp.getIDcliente() == cTemp.getID()) {
                                                        System.out.println("NOME DO CLIENTE: " + cTemp.getNome());
                                                        System.out.println(i + " - " + "ID: " + mTemp.getID()+ " | " +"ID DO CLIENTE: " + mTemp.getIDcliente()+ " | "+ "NUMERO: " + mTemp.numero+ " | " + "ESTADO: " + mTemp.getEstado()+ " | " + "TOTAL GASTO: " + mTemp.getTotalGasto()+ " | " + "DESCRIÇÃO: " + mTemp.getDescricao());
                                                        break;
                                                    }
                                                }
                                            }
                                            
                                        }
                                    }
                                    i++;

                                }
                                
                                int op = 0; //opcao

                                Scanner scan = new Scanner(System.in);

                                System.out.println("\nINTRODUZA UMA OPÇAO: ");
                                op = scan.nextInt();
                                scan.nextLine();
                                
                                String reparacao;
                                System.out.println("\nDESCRIÇAO DA REPARAÇÃO: ");
                                reparacao = scan.nextLine();
                                
                                marcacao[op].setDescricao(reparacao);

                                marcacao[op].setEstado(Estado.Concluido);
                                
                                String TotalGasto;
                                System.out.println("\nINTRODUZA O TOTAL GASTO: ");
                                TotalGasto=scan.nextLine();
                                
                                marcacao[op].setTotalGasto(TotalGasto);

                                gravar(clientes, veiculo, mecanicos, marcacao);
                                
                                break;
                                
                        case 5:
                                 int j = 0;
                                 Scanner scannn = new Scanner(System.in);
                                for (Marcacao mTemp : marcacao) {
                                    if (mTemp != null) {
                                       

                                            for (Cliente cTemp : clientes) {
                                                if (cTemp != null) {
                                                    if (mTemp.getIDcliente() == cTemp.getID()) {
                                                        System.out.println("NOME DO CLIENTE: " + cTemp.getNome());
                                                         System.out.println(j + " - " + "ID: " + mTemp.getID()+ " | " +"ID DO CLIENTE: " + mTemp.getIDcliente()+ " | "+ "NUMERO: " + mTemp.numero+ " | " + "ESTADO: " + mTemp.getEstado()+ " | " + "TOTAL GASTO: " + mTemp.getTotalGasto()+ " | " + "DESCRIÇÃO: " + mTemp.getDescricao());
                                                        break;
                                                    }
                                                }
                                            }
                                     
                                    }
                                    j++;

                                }
                                int opp = 0; //opcao
                                int ap = 0;
                          

                                System.out.println("\nINTRODUZA UMA OPÇÃO: ");
                                opp = scannn.nextInt();

                                System.out.println("\nINTRODUZA AGORA PARA QUE ESTADO QUER MUDAR:\n ");
                                System.out.println("\t\t 1 - Aceite, 2 - Nao_aceite, 3 - Cancelada, 4 - Em_tratamento, 5 - Concluido ");
                                ap=scannn.nextInt();
                                
                                if (ap == 1){
                                    
                                    marcacao[opp].setEstado(Estado.Aceite);
                                } 
                                if (ap == 2){
                                    
                                    marcacao[opp].setEstado(Estado.Nao_aceite);
                                } 
                                if (ap == 3){
                                    
                                    marcacao[opp].setEstado(Estado.Cancelada);
                                } 
                                if (ap == 4){
                                    
                                    marcacao[opp].setEstado(Estado.Em_tratamento);
                                } 
                                if (ap == 5){
                                    
                                    marcacao[opp].setEstado(Estado.Concluido);
                                }   

                                gravar(clientes, veiculo, mecanicos, marcacao);
                                break;
                                
                                case 0:

                                //gravar(clientes, veiculo, mecanicos, marcacao);
                                opcao3 = 0;
                                // System.exit(0);
                                break;
                                
                        }

                    } while (opcao3 != 0);
                    break;

                case 0:

                    System.exit(0);
                    break;
            }

        } while (opcao != 0);

    }

    public static Cliente inserirCliente(Cliente array[]) {

        Scanner scanner = new Scanner(System.in);

        int id;
        String nome, morada;

          do {
            System.out.println("INTRODUZA O ID DO CLIENTE: ");
            id = scanner.nextInt();
            scanner.nextLine();

            if (id < 0) {
                System.out.println("O NUMERO TEM QUE SER POSITIVO!");
                continue;
            }

            for (Cliente mTemp : array) {
                if (mTemp != null) {
                    if (mTemp.getID()== id) {
                        System.out.println("O ID NAO DEVE SER REPETIDO ");
                        id = -1;
                        break;
                    }
                }
            }

        } while (id < 0);

        System.out.println("INSIRA O NOME DO CLIENTE");
        nome = scanner.nextLine();

        System.out.println("INSIRA A MORADA");
        morada = scanner.nextLine();

        Cliente cTemp = new Cliente(id, nome, morada);

        return cTemp;

    }

    public static Mecanico inserirMecanico(Mecanico array[]) {

        Scanner scanner = new Scanner(System.in);

        int id;
        String nome, morada;

                do {
            System.out.println("INTRODUZA O ID DO MECANICO: ");
            id = scanner.nextInt();
            scanner.nextLine();

            if (id < 0) {
                System.out.println("O NUMERO TEM QUE SER POSITIVO!");
                continue;
            }

            for (Mecanico mTemp : array) {
                if (mTemp != null) {
                    if (mTemp.getID()== id) {
                        System.out.println("O ID NAO DEVE SER REPETIDO ");
                        id = -1;
                        break;
                    }
                }
            }

        } while (id < 0);
        

        System.out.println("INSIRA O NOME DO MECANICO");
        nome = scanner.nextLine();

        System.out.println("INSIRA A MORADA");
        morada = scanner.nextLine();

        Mecanico cliTempm = new Mecanico(id, nome, morada);

        return cliTempm;

    }

    public static void inserirVeiculo(Veiculo array[]) {

        int numero;
        String marca;
        int ano;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("INTRODUZA O NUMERO DO VEICULO: ");
            numero = scanner.nextInt();
            scanner.nextLine();

            if (numero < 0) {
                System.out.println("O NUMERO TEM QUE SER POSITIVO!");
                continue;
            }

            for (Veiculo mTemp : array) {
                if (mTemp != null) {
                    if (mTemp.getNumero() == numero) {
                        System.out.println("O NUMERO NAO DEVE SER REPETIDO ");
                        numero = -1;
                        break;
                    }
                }
            }

        } while (numero < 0);

        System.out.println("INTRODUZA A MARCA DO VEICULO");
        marca = scanner.nextLine();

        System.out.println("INTRODUZA O ANO DO VEICULO");
        ano = scanner.nextInt();
        scanner.nextLine();

        for (int x = 0; x < 50; x++) {
            if (array[x] == null) {
                array[x] = new Veiculo(numero, marca, ano);
                System.out.println("INSERIDO!");
                return;
            }
        }
        System.out.println("ERRO AO INSERIR");
    }

    public static void listarCliente(Cliente array[]) {

        for (Cliente dTemp : array) {
            if (dTemp != null) {
                System.out.println("ID: " + dTemp.getID() + " | NOME: " + dTemp.getNome() + " | MORADA: " + dTemp.getMorada() + "\n");
            }
        }
    }

    public static void listarVeiculo(Veiculo array[]) {

        for (Veiculo dTemp : array) {
            if (dTemp != null) {
                System.out.println("NUMERO: " + dTemp.getNumero() + " | MARCA: " + dTemp.getMarca() + " | ANO: " + dTemp.getAno() + "\n");
            }
        }
    }
    
    public static void listarMecanicos(Mecanico array[]) {

        for (Mecanico dTemp : array) {
            if (dTemp != null) {
                System.out.println("ID: " + dTemp.getID() + " | NOME: " + dTemp.getNome() + " | MORADA: " + dTemp.getMorada() + "\n");
            }
        }
    }
    
    
       public static void listarMarcacoes(Marcacao array[]) {

        for (Marcacao dTemp : array) {
            if (dTemp != null) {
                System.out.println("ID" + dTemp.getID() + " |" + " ID DO CLIENTE: " + dTemp.getIDcliente() + " | NUMERO: " + dTemp.getNumero()+ " | ESTADO: " + dTemp.getEstado()+ " | TOTAL GASTO: " + dTemp.getTotalGasto()+ " | DESCRIÇÃO: " + dTemp.getDescricao() + "\n");
            }
        }
    }
       
       public static void listarEstado(Marcacao array[]) {
           
        for (Marcacao dTemp : array) {
            if (dTemp != null) {
                System.out.println("ID" + dTemp.getID() + " |" + " ID DO CLIENTE: " + dTemp.getIDcliente() + " | NUMERO: " + dTemp.getNumero()+ " | ESTADO: " + dTemp.getEstado() + "\n");
            }
        }
        
    }
       
     

    public static Marcacao realizarMarcacao(Cliente array[], int id) {

        int ID;
        String nome, morada;

        Scanner scanner = new Scanner(System.in);
        Cliente clienteTemp = null;

        do {
            System.out.println("INTRODUZA o ID DO CLIENTE: ");
            ID = scanner.nextInt();

            for (Cliente mTemp : array) {
                if (mTemp != null) {
                    if (mTemp.getID() == ID) {
                        clienteTemp = mTemp;
                        break;
                    }
                }
            }

            if (clienteTemp == null) {
                System.out.println("O ID NAO EXISTE!");
            }

        } while (clienteTemp == null);
        Marcacao mTemp = new Marcacao();

        int numeroveiculo;

        mTemp.setIDcliente(clienteTemp.getID());
        System.out.println("INTRODUZA O NUMERO DO VEICULO: ");
        numeroveiculo = scanner.nextInt();
        mTemp.setNumero(numeroveiculo);
        mTemp.setEstado(Estado.Aceitar);
        mTemp.setID(id);
        
        
        return mTemp;

    }

    //Escreve nos ficheiros os arrays cientes e veiculos
    public static void gravar(Cliente[] clientes, Veiculo[] veiculo, Mecanico[] mecanicos, Marcacao[] marcacao) {
        
        try {
            String fileClientes = "Files/clientes.txt";
            String fileVeiculos = "Files/veiculos.txt";
            String fileMecanicos = "Files/mecanicos.txt";
            String fileMarcacao = "Files/marcacoes.txt";

            FileWriter fileclientes = new FileWriter(fileClientes);
            fileclientes.write("");
            

            for (Cliente cTemp : clientes) {
                if (cTemp != null) {
                    WriteFile(fileClientes, cTemp.toString());
                    
                }

            }

            FileWriter fileveiculos = new FileWriter(fileVeiculos);
            fileveiculos.write("");
            for (Veiculo vTemp : veiculo) {
                if (vTemp != null) {
                    WriteFile(fileVeiculos, vTemp.toString());
                }
            }

            FileWriter filemecanicos = new FileWriter(fileMecanicos);
            filemecanicos.write("");
            for (Mecanico vTemp : mecanicos) {
                if (vTemp != null) {
                    WriteFile(fileMecanicos, vTemp.toString());
                }
            }

            FileWriter filemarcacao = new FileWriter(fileMarcacao);
            filemarcacao.write("");
            for (Marcacao mTemp : marcacao) {
                if (mTemp != null) {
                    WriteFile(fileMarcacao, mTemp.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Escreve no ficheiro no modo append 
    public static void WriteFile(String file, String string) {

        try ( FileWriter f = new FileWriter(file, true);  BufferedWriter b = new BufferedWriter(f);  PrintWriter p = new PrintWriter(b);) {
            p.println(string);
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    

}