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

Una vez echo esto, seras redirigido a la vista home de aplicacion y deberas buscar tu producto nuevamente (en la aplicacion en produccion seria mas conveniente que se te rediriga a la misma pagina donde tenias el producto). Ahora solo das click en _ofertar_ y confirmas la compra por MercadoPago !

###Desarrollo

Esta aplicacion fue desarrollada desde Eclipse con ADT, utilizando las librerias JodaTime, Retrofit, OkHTTP.

Para el testeo de la aplicacion en un flujo completo, desde la busqueda hasta la compra,
utilizamos los usuarios de testeo provistos por la [API de MercadoPago](http://developers.mercadopago.com/documentation/create-test-users), siendo estos:

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

* Opcion de seguir las subastas en las que ya has ofertado.
* Que se notifique cuando alguien oferto mas en un articulo que estamos siguiendo.
* La aplicacion debe actualizar su contenido en vivo. Ejemplo, que se avise que una persona acaba de ofertar en un producto que estoy mirando.
