## LP3A5_Aula03
### produtorConsumidor1
**Exercício - Problema do Produtor e Consumidor (Versão 1)**   
O programa cria um objeto Buffer, um Produtor, um Consumidor e lança o produtor e consumidor. Ocorre a sincronização de Threads a baixo nível, nos métodos put() e get() do Buffer, também são usados os métodos wait() e notifyAll(). Resultado da execução desse código pelo console do Eclipse IDE:  
![image](https://user-images.githubusercontent.com/70042571/164563705-e077d27b-6b0a-4f33-8d94-200b074db66b.png)

### produtorConsumidor2
**Exercício - Problema do Produtor e Consumidor (Versão 2)** 
Programa utiliza semáforos em Java; chamadas são sincronizadas para put() e get(), sendo a sequência das chamadas put() e get() tratada por dois semáforos: semProd e semCon.  
