package projeto1;

import java.util.ArrayList;
import java.util.Scanner;
import gurobi .*;



public class Sistema {
    public static Scanner sc = new Scanner(System.in);
    
    public static ArrayList<Funcionario> fun = new ArrayList();
    public static ArrayList<Administrador> adm = new ArrayList();
    public static ArrayList<Estoque> est = new ArrayList();
    public static ArrayList<Estoque> est1 = new ArrayList();
    public static Estoque et = new Estoque(0,0,0,0,0);
    public static Funcionario func = new Funcionario(0,"","");
    public static Estoque eto = new Estoque(0,0,0,0,0);
    
    public static void main(String[] args) {
       
       autenticar();
       //solver();
    }
     
     public static void menuF(){
            int opcao;
            while(true){
                System.out.println("\nMenu Funcionario");
                System.out.println("\nOpção 1 - Realizar uma venda");
                System.out.println("Opção 2 - Autenticar novamente");
                System.out.println("Opção 0 - Finaliza o programa");
                opcao = Integer.parseInt(sc.nextLine());                
                switch (opcao){
                        case 1:
                            efetuarVenda();
                            break;
                            
                        case 2:
                            autenticar();
                            break;
                            
                        default:
                            System.out.println("Programa Finalizado");
                            System.out.println("----------------------------");
                            System.exit(0);
            }
        }
    }
    
    public static void menuP(){
            int opcao;
            while(true){
                System.out.println("\nMenu Padeiro");
                System.out.println("\nOpção 1 - Produtos Gastos");       
                System.out.println("Opção 2 - Inserir a produção");
                System.out.println("Opção 3 - Autenticar novamente");
                System.out.println("Opção 0 - Finaliza o programa");
                opcao = Integer.parseInt(sc.nextLine());
                
                switch (opcao){
                        case 1:
                            produtosGastos();
                            break;
                        
                        case 2:
                            producao();
                            break;                            
                            
                        case 3:
                            autenticar();
                            break;
                            
                        default:
                            System.out.println("Programa Finalizado");
                            System.out.println("----------------------------");
                            System.exit(0);
            }
        }
    }
    
    
     public static void menuA(){
            int opcao;
            while(true){
                System.out.println("\nMenu Administrador");
                System.out.println("\nOpção 1 - Estoque");
                System.out.println("Opção 2 - Balanço");
                System.out.println("Opção 3 - Autenticar");
                System.out.println("Opção 0 - Finaliza o programa");
                opcao = Integer.parseInt(sc.nextLine());
                
                switch (opcao){
                        case 1:
                            controlarEstoque();
                            break;
                            
                        case 2:
                            balancoDoMes();
                            break;
                            
                        case 3:
                            autenticar();
                            
                        default:
                            System.out.println("Programa Finalizado");
                            System.out.println("----------------------------");
                            System.exit(0);
            }
        }
    }
   
     
     
     
     public static void autenticar(){
        while (true){  
            System.out.println("\nOpção 1 - Login");
            System.out.println("Opção 0 - Finalizar programa");
            int op = Integer.parseInt(sc.nextLine());
            Padeiro pd = new Padeiro("","");
            Funcionario fn = new Funcionario("","");
            Administrador ad = new Administrador(0,"","");
            ad.setLogin("01");
            ad.setSenha("01");           
            pd.setLogin("02");
            pd.setSenha("02");
            fn.setLogin("03");
            fn.setSenha("03");            
            switch(op){
                case 1:
                    System.out.println("\nDigite o Login: ");
                    String login = sc.nextLine();
                    System.out.println("Digite a Senha: ");
                    String senha = sc.nextLine();
                    
                    if(ad.getLogin().equals(login) && ad.getSenha().equals(senha)){ 
                        menuA();
                        break;
                    }
                    if( pd.getLogin().equals(login) && pd.getSenha().equals(senha)){ 
                        menuP();
                        break;
                    }
                    if( fn.getLogin().equals(login) && fn.getSenha().equals(senha)){
                        menuF();
                        break;
                   }else{
                        System.out.println("Usuario não encontrado!!");
                        break;
                        }                                                
                                       
                default:
                System.out.println("Programa finalizado");
                System.out.println("----------------------------");
                System.exit(0);
            }
        }    
    }
     
     
    public static void produtosGastos(){
       
        while (true){  
            System.out.println("\nOpção 1 - Inserir a quantidade de material gasto");
            System.out.println("Opção 2 - Total de todos os produtos gasto em KGs");
            System.out.println("Opção 3 - Menu");
            System.out.println("Opção 0 - Finalizar programa");
            int op = Integer.parseInt(sc.nextLine());
           
            switch(op){
                case 1:
                    modificarEstoque();
                   break;
                
                case 2:
                    imprimirEstoque();
                    break;    
                    
                case 3:
                    menuP();
                default:
                    System.out.println("Programa finalizado");
                    System.out.println("----------------------------");
                    System.exit(0);
            }        
        } 
    }
    
    public static void inserirProdutos(){
        
        est.add(et);            
        System.out.println("\nInsira a quantidade de Trigo: ");
        et.setTrigo(Integer.parseInt(sc.nextLine()));
        System.out.println("Insira a quantidade de Açúcar: ");
        et.setAcucar((Integer.parseInt(sc.nextLine())));
        System.out.println("Insira a quantidade de Sal: ");
        et.setSal((Integer.parseInt(sc.nextLine())));
    }
    
 
    
    public static void controlarEstoque(){
        
        while (true){  
            System.out.println("\nOpção 1 - Inserir produto no estoque");
            System.out.println("Opção 2 - Verificar estoque");
            System.out.println("Opção 3 - Autenticar");
            System.out.println("Opção 0 - Finalizar programa");
            int op = Integer.parseInt(sc.nextLine());
                     
            switch(op){
                case 1:
                    inserirProdutos();
                    break;    
                    
                case 2:   
                    imprimirEstoque();
                    break;        
                    
                case 3:
                    autenticar();
                default:
                    System.out.println("Programa finalizado");
                    System.out.println("----------------------------");
                    System.exit(0);
            }        
        } 
    }
    
    public static void imprimirEstoque(){
        
        for(Estoque estoquee : est){
            System.out.println(estoquee);
            
        }
    }
        
         
    
    
    public static void modificarEstoque(){
       for(Estoque estoque : est){
           System.out.println("\nInsira a quantidade de trigo utilizada");
           int valorInserido = (Integer.parseInt(sc.nextLine()));
           System.out.println("Insira a quantidade de açúcar utilizada");
           int valorInserido2 = (Integer.parseInt(sc.nextLine()));
           System.out.println("Insira a quantidade de sal utilizada");
           int valorInserido3 = (Integer.parseInt(sc.nextLine()));
           
           if(estoque.getTrigo() >= valorInserido){
                int trigo = estoque.getTrigo();
                int gasto = trigo - valorInserido;
                estoque.setTrigo(gasto);
           }else{
                System.out.println("\nQuantidade insuficiente de Trigo no estoque!!!");
           }
            
            if(estoque.getAcucar() >= valorInserido2){
                int acucar = estoque.getAcucar();
                int gasto2 = acucar - valorInserido2;
                estoque.setAcucar(gasto2);
           }else{
               System.out.println("\nQuantidade insuficiente de Açúcar no estoque!!!");
           }
           
           if(estoque.getSal() >= valorInserido3 ){
                int sal = estoque.getSal();
                int gasto3 = sal - valorInserido3;
                estoque.setSal(gasto3);
           
           }else{
               System.out.println("\nQuantidade insuficiente de Sal no estoque!!!");
           }
            
           
           
       }
    }
    
    
    public static void efetuarVenda(){
        est1.add(eto);
        fun.add(func);
        System.out.println("\nInsira a quantidade de pão vendido: ");
        int valorInserido = (Integer.parseInt(sc.nextLine()));
            for(Estoque esto : est1){
                if(esto.getPaoProduzido() >= valorInserido){
                    int producao = esto.getPaoProduzido();
                    int total = producao - valorInserido;
                    esto.setPaoProduzido(total);
                    
                    int vendido = esto.getPaoVendido();
                    int totalVendido = vendido + valorInserido;
                    esto.setPaoVendido(totalVendido);
                    
                    System.out.println("Insira o valor total da venda: ");
                    int valorInserido2 = (Integer.parseInt(sc.nextLine()));
                    for(Funcionario funcionario : fun){
                        int valor = funcionario.getValor();
                        int total1 = valor + valorInserido2;
                        funcionario.setValor(total1);
                        break;
                    }break;
               }else{
                    System.out.println("\nQuantidade insuficiente de pão no estoque!!!");
                    break;
               }

            }
            
         
           
    }
        
    public static void producao(){        
        est.add(et);
        est1.add(eto);
        System.out.println("\nInsira a quantidade de pão produzida");
        int inserido = (Integer.parseInt(sc.nextLine()));
        et.setPaoProduzido(inserido); 
        eto.setPaoProduzido(inserido); 
     }
    
    
    public static void balancoDoMes(){
           
            for(Estoque esto : est){
                int pao = esto.getPaoProduzido();                 
                System.out.println("\nQuantidade de pão produzida: " + pao);
                break;
             }
            for(Estoque esto1 : est1){
                int pao2 = esto1.getPaoProduzido();
                System.out.println("Quantidade de pão no estoque: " + pao2);
                int pao1 = esto1.getPaoVendido();
                System.out.println("Quantidade de pão vendida: " + pao1);
                break;
            }
            for(Funcionario funcionario : fun){
                 System.out.println(funcionario);
                 break;
             }
            
        
    } 
    
    
   
    
    public static void solver(){        
       
      try {
      GRBEnv    env   = new GRBEnv("qp.log");
      GRBModel  model = new GRBModel(env);

      // Create variables

      GRBVar x = model.addVar(0.0, GRB.INFINITY, 0.0, GRB.CONTINUOUS, "x");
      GRBVar y = model.addVar(0.0, GRB.INFINITY, 0.0, GRB.CONTINUOUS, "y");
      GRBVar z = model.addVar(0.0, GRB.INFINITY, 0.0, GRB.CONTINUOUS, "z");

      // Set objective

      GRBQuadExpr obj = new GRBQuadExpr();
      obj.addTerm(1.0, x, x);
      obj.addTerm(1.0, x, y);
      obj.addTerm(1.0, y, y);
      obj.addTerm(1.0, y, z);
      obj.addTerm(1.0, z, z);
      obj.addTerm(2.0, x);
      model.setObjective(obj);

      // Add constraint: x + 2 y + 3 z >= 4

      GRBLinExpr expr = new GRBLinExpr();
      expr.addTerm(1.0, x); expr.addTerm(2.0, y); expr.addTerm(3.0, z);
      model.addConstr(expr, GRB.GREATER_EQUAL, 4.0, "c0");

      // Add constraint: x + y >= 1

      expr = new GRBLinExpr();
      expr.addTerm(1.0, x); expr.addTerm(1.0, y);
      model.addConstr(expr, GRB.GREATER_EQUAL, 1.0, "c1");

      // Optimize model

      model.optimize();

      System.out.println(x.get(GRB.StringAttr.VarName)
                         + " " +x.get(GRB.DoubleAttr.X));
      System.out.println(y.get(GRB.StringAttr.VarName)
                         + " " +y.get(GRB.DoubleAttr.X));
      System.out.println(z.get(GRB.StringAttr.VarName)
                         + " " +z.get(GRB.DoubleAttr.X));

      System.out.println("Obj: " + model.get(GRB.DoubleAttr.ObjVal) + " " +
                         obj.getValue());
      System.out.println();


      // Change variable types to integer

      x.set(GRB.CharAttr.VType, GRB.INTEGER);
      y.set(GRB.CharAttr.VType, GRB.INTEGER);
      z.set(GRB.CharAttr.VType, GRB.INTEGER);

      // Optimize again

      model.optimize();

      System.out.println(x.get(GRB.StringAttr.VarName)
                         + " " +x.get(GRB.DoubleAttr.X));
      System.out.println(y.get(GRB.StringAttr.VarName)
                         + " " +y.get(GRB.DoubleAttr.X));
      System.out.println(z.get(GRB.StringAttr.VarName)
                         + " " +z.get(GRB.DoubleAttr.X));

      System.out.println("Obj: " + model.get(GRB.DoubleAttr.ObjVal) + " " +
                         obj.getValue());

      // Dispose of model and environment

      model.dispose();
      env.dispose();

    } catch (GRBException e) {
      System.out.println("Error code: " + e.getErrorCode() + ". " +
          e.getMessage());
    }
  }
}