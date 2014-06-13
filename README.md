subasta Ya
==========

Dev: Franco Augusto Arolfo

Mobile app desarrollada para el Desafio Mobile 2014 de MercadoLibre.com.

La idea es simple: **una aplicacion mobile para participar en subastas on line desde cualquier lugar donde estes**. 
Asi como en [tinder](http://www.gotinder.com/) se postulan personas y uno decide si dar NEXT u OK, en _subasta Ya_ se listan los productos que vos buscas y se estan subastando en ese momento, con la opcion de dar NEXT, PREV u OFERTAR. **Simple**.

![screenshots](/screenshots/screens.png "screenshots")

La intencion de esta aplicacion es fomentar el uso de subastas en los servicios de venta online, en este caso MercadoLibre. Esatmos en una epoca donde las subastas se ven en la television en muchos programas y shows (el ejemplo mas famoso es ["El Precio de la Historia"](http://ar.tuhistory.com/programas/el-precio-de-la-historia.html) de History Channel), es el momento ideal para una app que se basa en subastar lo que queres donde quiera que estes.

Un punto importante de esta aplicacion es que debe ser SIMPLE. Ver productos y ofertar o pasar al proximo. 
Debe ser usable para cualquiera, eliminando las incertidumbres que el usuario pueda tener sobre las subastas en MercadoLibre, y asi, fometando su uso.

###Ejecucion

En la carpeta `/bin` se encuentra la demo en formato `.apk`.
Para ejecutarla, sigue la [documentacion](http://developer.android.com/tools/building/building-cmdline.html#RunningOnEmulator) de Android.

Ahora ya estas usando _subasta Ya_ ! 
Busca el producto que te interesa y da click en _ofertar_ cuando lo encuentres. Si no estas logueado, se te presentara el flujo de autenticacion de MercadoLibre.
Si te recien te logueas, se te redirigira a la pagina pri

###Desarrollo

Esta aplicacion fue desarrollada desde Eclipse con ADT, utilizando las librerias JodaTime, Retrofit, OkHTTP.

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
