subasta Ya
==========

Dev: Franco Augusto Arolfo

Mobile app desarrollada para el Desafio Mobile 2014 de MercadoLibre.com, quedando seleccionada como una de las [top 5 apps](http://developers.mercadolibre.com/mobile-challenge-winner-and-finalists/).

La idea es simple: **una aplicación mobile para participar en subastas on line desde cualquier lugar donde estés**. 
Así como en [tinder](http://www.gotinder.com/) se postulan personas y uno decide si dar NEXT u OK, en _subasta Ya_ se listan los productos que vos buscás y se están subastando en ese momento, con la opción de dar NEXT, PREV u OFERTAR. **Simple**.

![screenshots](/screenshots/screens.png "screenshots")

La intención de esta aplicación es fomentar el uso de subastas en los servicios de venta online, en este caso MercadoLibre. Estamos en una época donde las subastas se ven en la televisión en muchos programas y shows (el ejemplo mas famoso es ["El Precio de la Historia"](http://ar.tuhistory.com/programas/el-precio-de-la-historia.html) de History Channel). Con tanta difusión, es el momento ideal para una app que se base en subastar lo que querés donde quiera que estés y de la manera más fácil.

Un punto importante de esta aplicación es que debe ser SIMPLE. Ver productos y ofertar o pasar al próximo. 
Debe ser _usable_ para cualquiera, eliminando las incertidumbres que el usuario pueda tener sobre las subastas en MercadoLibre, y así, fomentar su uso.

###Ejecución

En la carpeta `/target` se encuentra la demo en formato `.apk`.

Desde el directorio `platform-tools/` de tu sdk, ejecuta:

```shell
$ android avd
```

Y desde la vista _Virtual Devices_ selecciona un AVD y dá click en __Start__.

Ahora solo instala el `.apk` en tu emulador y abre la aplicación

```shell
$ adb install subastaYa.apk
```

Ya estás usando _subasta Ya_ ! 

Buscá el producto que te interesa y dá click en _ofertar_ cuando lo encuentres. Si no estás logueado, se te presentará la pantalla de autenticación de MercadoLibre.

Una vez echo ésto, serás redirigido a la vista home de aplicación y deberás buscar tu producto nuevamente (en la aplicación en producción sería más conveniente que se te rediriga a la misma página donde tenías el producto). Ahora solo dás click en _ofertar_ y confirmás la compra por MercadoPago !

__Limitación de la demo:__ No hallé manera de comprar un producto en subastas por medio de la API. Utilicé un `POST` a `/orders` con un `order_items` que contenía al producto en cuestión y un `price` con el precio ofertado pero ésto no fue aceptado por la API debido al campo `price` y no encontré documentación sobre estas llamadas en particular. Pero la demo se entiende espero :)

###Desarrollo

Esta aplicación fue desarrollada desde Eclipse con ADT, utilizando las librerias JodaTime, Retrofit, OkHTTP.

Para el testeo de la aplicación en un flujo completo, desde la búsqueda hasta la compra,
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

* Opción de seguir las subastas en las que ya has ofertado.
* El label donde se indica el tiempo que resta para que termine la subasta debe ir bajando en vivo, no ser un label estático.
* Que se notifique cuando alguien ofertó mas en un artículo que estamos siguiendo.
* La aplicación debe actualizar su contenido en vivo. Ejemplo, que se avise que una persona acaba de ofertar en un producto que estoy mirando.


##Licencia

MIT


