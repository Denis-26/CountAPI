# Count API

## Methods
    
GET

1) http://localhost:8080/api/count/get/
    - description: Возвращает счетчик по имени
    - params
       - name: String
 
           
2) http://localhost:8080/api/count/sum/
    - description: Возвращает сумму всех счетчиков
    
    
3) http://localhost:8080/api/count/names/
    - description: Возвращает все имена счетчиков
    
    
POST

1) http://localhost:8080/api/count/create/   
    - description: Создает счетчик по имени
    - params
       -  name: String
          
            
2) http://localhost:8080/api/count/remove/   
    - description: Удаляет счетчик по имени
    - params
        - name: String
        
        
3) http://localhost:8080/api/count/increment
    - description: Инкрементирует счетчик по имени
    - params
        - name: String
              