## LP3_Aula03

### produtorConsumidor1
**Exercício - Problema do Produtor e Consumidor (Versão 1)**   
O programa cria um objeto Buffer, um Produtor, um Consumidor e lança o produtor e consumidor. Ocorre a sincronização de Threads à baixo nível, nos métodos put() e get() do Buffer, também são usados os métodos wait() e notifyAll().  
Resultado da execução do programa pelo console do Eclipse IDE: 

![image](https://user-images.githubusercontent.com/70042571/164563705-e077d27b-6b0a-4f33-8d94-200b074db66b.png)


### produtorConsumidor2
**Exercício - Problema do Produtor e Consumidor (Versão 2)**  
Programa utiliza semáforos em Java; chamadas são sincronizadas para put() e get(), sendo a sequência das chamadas put() e get() tratada por dois semáforos: semProd e semCon.  
Resultado da execução do programa pelo console do Eclipse IDE: 

![image](https://user-images.githubusercontent.com/70042571/164786133-2305a30c-a308-4405-aff6-1bba8932f44c.png)
 
 
### produtorConsumidor3
**Exercício - Problema do Produtor e Consumidor (Versão 3)**  
Programa faz uso de Threads em Java; possui uma **lista LinkedList -** para armazenar uma lista de trabalhos na fila; **tamanho variável -** para verificar se a lista está cheia ou não; **controle de inserção e remoção da lista -** para não inserir na lista se estiver cheia ou remover se estiver vazia. Possui dois loops externos infinitos: um para inserir e outro para extrair valores na lista; também utiliza os métodos wait(), notify() e sleep().  
Resultado da execução do programa pelo console do Eclipse IDE: 

![image](https://user-images.githubusercontent.com/70042571/164786706-468abb81-0072-436a-b338-dd56146c3d23.png)  


### jantarFilosofos, utils e AppTest
**Author professor Diego Caldas - Problema dos Filósofos Jantando**  
Programa implementa três soluções diferentes para o Problema dos Filósofos Jantando: testeDeadlock, testeStarved e testeOK; incluindo a classe AppTest que realiza teste através do framework JUnit, também faz uso de interfaces, classe abstrata e enum.  
Resultado das execuções do programa para cada teste:  

![image](https://user-images.githubusercontent.com/70042571/164797039-03942e26-8347-43fe-941b-1f8238cc40dc.png)  

![image](https://user-images.githubusercontent.com/70042571/164798627-f682d216-b8bb-4a88-8d0c-18acc31dad8c.png)  
 
 
![image](https://user-images.githubusercontent.com/70042571/164799036-13dd38a3-2d66-43bb-bb02-d3337382879b.png)  

![image](https://user-images.githubusercontent.com/70042571/164799116-4cfbd3e4-7cc9-4722-9e9e-74e6493e0411.png)  
  
  
![image](https://user-images.githubusercontent.com/70042571/164799399-a3f647b5-002c-468a-acb0-909a52757715.png)  

![image](https://user-images.githubusercontent.com/70042571/164799488-efa07a6b-474c-4cd6-a7fb-2dda81b9be10.png)  
   
  
![image](https://user-images.githubusercontent.com/70042571/164800415-5bbc84cb-a320-4c7d-9435-3cb5374ea834.png)  


### Referências 

w3big.com. Exemplos Java - problema do produtor/consumidor. Disponível em: <http://www.w3big.com/pt/html/thread-procon.html>. Acesso em: 15 abr. 2022.  

MIGLANI, Gaurav. SOLUÇÃO PRODUTOR-CONSUMIDOR USANDO SEMÁFOROS EM JAVA | CONJUNTO 2. Acervo Lima. Disponível em: <https://acervolima.com/solucao-produtor-consumidor-usando-semaforos-em-java-conjunto-2/#:~:text=O%20problema%20descreve%20dois%20processos,um%20peda%C3%A7o%20de%20cada%20vez>. Acesso em: 15 abr. 2022.  

MAHRSEE, Rishabh. SOLUÇÃO PRODUTOR-CONSUMIDOR USANDO THREADS EM JAVA. Acervo Lima. Disponível em: <https://acervolima.com/solucao-produtor-consumidor-usando-threads-em-java/>. Acesso em: 21 abr. 2022.
