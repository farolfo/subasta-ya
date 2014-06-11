subasta Ya
==========

Dev: Franco Augusto Arolfo

Mobile app desarrollada para el Desafio Mobile 2014 de MercadoLibre.com.

La idea es muy simple: **una aplicacion mobile para participar en subastas on line desde cualquier lugar donde estes**. Asi como en [tinder](http://www.gotinder.com/) se postulan personas y uno decide si dar NEXT u OK, en _subasta Ya_ se postulan los productos que vos buscas y que se estan subastando en este momento, con la opcion de dar NEXT, PREV u OFERTAR. **Simple**.

![home view image](/screenshots/home_view.png "Vista de home")
![product view image](/screenshots/product_view.png "Vista de un producto")

La intencion de esta aplicacion es fomentar el uso de subastas en los servicios de venta online, en este caso MercadoLibre. Esatmos en una epoca donde las subastas se ven en la tele en muchos programas y shows, es el momento ideal para una app que se basa en subastar lo que queres donde quiera que estes.

Un punto importante de esta aplicacion es que debe ser SIMPLE. Ver productos y ofertar o pasar al proximo. Debe ser usable para cualquiera, eliminando las incertidumbres que el usuario pueda tener sobre las subastas en MercadoLibre, y asi, fometando su uso.

###Desarrollo

Para el testeo de la aplicacion en un flujo completo, desde la busqueda hasta la compra,
utilizamos los usuarios de testeo que nos provee MercadoLibre en la API:

    http://developers.mercadopago.com/documentation/create-test-users

Siendo estos:

* Vendedor de entradas de los Beatles:

    ```javascript
    {
        "id": 159620282,
        "nickname": "TETE8404306",
        "password": "qatest2672",
        "site_status": "active",
        "email": "test_user_95217195@testuser.com"
    }
    ```

* Comprador:

    ```javascript
    {
        "id": 159622242,
        "nickname": "TETE1177057",
        "password": "qatest3944",
        "site_status": "active",
        "email": "test_user_14674777@testuser.com"
    }
    ```

###En la proxima version

* Opcion de seguir la subasta en las que estas involucrado
* Que avise cuando alguien oferto mas en un articulo que estamos siguiendo
