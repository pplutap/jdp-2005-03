## 1. Opis projektu
Backendowa część implementacji dla platformy ecommerce, utworzona w ramach projektu zespołowego, w toku kursu **Java Developer Puls**.

## 2. Demo

## 3. Wymagania przed uruchomieniem
Do uruchomienia aplilacji niezbędna jest instalacji wirtualnej maszyny Javy (JVM).

## 4. Uruchomienie projektu

## 5. Opis endpointów
1. Product Controller zawiera następujące metody:
- v1/ecommercee/product/getProducts, wymaga żądania typu GET, zwraca obiekt JSON zawierający informację o wszystkich produktach znajdujacych się w bazie aplikacji;
- v1/ecommercee/product/getProduct,  wymaga żądania typu GET oraz przekazania w argumencie zaputania numeru Id produktu, którego dane maja być wyświetlone, zwraca obiekt JSON zawierający informację o produkcie posiadającym wskazany nr Id;
- v1/ecommercee/product/deleteProduct, wymaga żądania typu DELETE, usuwa z bazy aplikacji produkt o wskazanym w argumencie Id;
- v1/ecommercee/product/createProduct, , wymaga żądania typu POST, pozwala na dodanie do bazy produktów aplikacji nowego produktu, o parametach wskazanych w argumencie żadania;
- v1/ecommercee/product/updateProduct, , wymaga żądania typu PUT, pozwala na modyfikację danych produktu znajdujacego się w bazie danych aplikacji.

## 6. Wykorzystanie

Projekt jest wstępną implementacją backendowej części implementacji dla sklepu internetowego. Można dalej rozwijać go do pełnej funkcjonalnosci oraz połączenia z frontendem.

## 7. Troubleshooting

