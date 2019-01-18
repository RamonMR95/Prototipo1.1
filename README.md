# MyPrototype1.1

## Práctica de aplicación

## 1. Revisión de los [Documentos de Proyecto](https://moodle.iescierva.net/mod/folder/view.php?id=26072) para conocer las características establecidas para el proyecto "JVida" en su segunda iteración.
Corresponde al segundo prototipo en el que se va a abordar una mejor implementación de las clases del modelo de datos junto a una restructuración de la la arquitectura de aplicación con tres capas.
El control de acceso del programa y la ejecución de una simulación de demostración del Juego de la Vida no cambiarán esencialmente.
Estarán afectados  los casos de uso "Controlar Acceso" y "Gestionar Simulación". 

## 2. Actualización del repositorio local del proyecto

- Importa, si es necesario como se hizo en la práctica anterior,
- Sincroniza el repositorio maestro local del proyecto JV2018 desde el repositorio remoto del proyecto: https://github.com/PyED2018/Proyecto.git

## 3. Creación de una copia de trabajo del proyecto

- A partir de la replica maestra local, copia el proyecto con el explorador de paquetes de eclipse.

- Asigna un nombre de trabajo adecuado para el prototipo1.1

## 4. Comprobación de la configuración del proyecto

El proyecto se organiza en dos carpetas de código fuente con los nuevos paquetes que deberán crearse para las clases indicadas:
- /src/java/ donde irá ubicada la clase principal del programa Java y los siguientes paquetes:
  - .accesoDato con una nueva clase llamada Datos que será el Almacén de Datos de la aplicación.
  - .accesoUsr con una nueva clase llamada Presentacion que tendrá los atributos y los elementos necesarios para la interacción con el usuario según las necesidades actuales de la aplicación.
  - .modelo con las clases Usuario, SesionUsuario, Simulacion. Nif, DireccionPostal, Correo y ClaveAcceso.
  
- /src/test/ que contendrá las clases de prueba de JUnit5 del proyecto. Se reproducirá la misma estructura de paquetes que en la carpeta /src/java. Si se proporciona código de los test de prueba no debe ser modificado nunca, salvo error constatado en su diseño. Sí puede ser ampliado con nuevos métodos adicionales de test para aumentar la cobertura.
  - .accesoDato con una nueva clase llamada DatosTest que tendrá los atributos y métodos necesarios para las pruebas de la clase Datos.
  - .accesoUsr con una nueva clase llamada PresentacionTest que tendrá los atributos y métodos necesarios para las pruebas de la clase Presentacion.
  - .modelo con las clases ...Test del modelo.

## 5. Implantación de la clase Fecha

- En la carpeta /src/java/, se debe crear un nuevo paquete llamado .util que contendrá una nueva clase para representar y manejar el tiempo en el programa.
- En la carpeta /src/test/, se debe crear también el nuevo paquete con una clase de Junit llamada FechaTest
Seguir la demostración realizada por el profesor para incorporar un objeto de la clase Calendar aplicando el patron adaptador en la clase Fecha.
- Refactorizar todas las clases que utilicen fechas para aplicar la nueva clase Fecha.
 
## 6. Implantación de nuevas clases del modelo
- Incorporar, en el paquete .modelo, las nuevas clases identificadas en el diagrama de clases UML correspondiente al modelo 1.1. Ver: Documentos del proyecto.
- Hay que definir los atributos que se detallan y especifican en el modelo.
- Algunas de las características o métodos de estas nuevas clases pueden estar ya implementadas en la clase Usuario. El proceso básico será trasladar esos métodos desde Usuario a la nueva clase que corresponda.
- Debe implementarse una encapsulación básica con atributos privados y sus correspondientes métodos de acceso en lectura y escritura.
- Deben incorporarse constructores (desde atributos, por defecto y a partir de un objeto de la misma clase) con la menor repetición de código y la implementación más limpia posible.
- Tanto en los métodos set...() como en los constructores de deben incorporar los mecanismos necesarios para asegurar que los atributos nunca toman valores inadecuados (null, datos con formato incorrecto, ...) para ello se incorporarán métodos internos específicos para la validación de los atributos.
- Redefinir adecuadamente los métodos clone(), hashCode(), equals() y toString().
- Creación de un método en la clase ClaveAcceso para encriptar la clave de acceso. Deben cumplirse las siguientes condiciones:
  - El método de pedido utilizará el algoritmo de César y se llamará encriptarCesar(). Realizar los ajustes necesarios, en todos los sitios del programa donde se maneja la clave de usuario, con el fin de tener en cuenta que las contraseñas siempre deben almacenarse encriptadas y que estas nunca deben desencriptarse cuando se verifican; por ejemplo en el inicio de sesión.
  - Alternativamente se puede utilizar un cifrado aplicando XOR entre cada letra de la contraseña -en claro- con una letra de una clave de 5 caracteres aleatorios. Esta clave se debe almacenar junto al texto de la contraseña encriptada con un formato adecuado.
- El método claveAccesoValida(); permirá comprobar si la contraseña es suficientemente compleja en cuanto a longitud y variedad de caracteres.
- Mejora de los métodos para validar. Para la validación de los los atributos de las clases se utilizarán expresiones regulares para la verificación del formato según los siguientes criterios:
  - El método NifValido(); permirá comprobar si un nif cumple el formato de ocho números y una letra; también comprobará si la letra es correcta.
- El método direccionValida(); permirá comprobar si la direccion cumple criterios básicos de básicos de formato.
- El método CorreoValido(); permirá comprobar si la dirección de correo electrónico tiene formato válido.

## 7. Modificación de la clase Usuario 
- Hacer coherente la clase con lo indicado en el diagrama de clases UML correspondiente al modelo 1.1. Ver: Documentos del proyecto.
  - Hay que modificar el tipo de los atributos para utilizar las nuevas clases que se han definido en el modelo.
  - Puede que haya que corregir varios errores que surgirán en otras clases que dependa de la clase Usuario.
- Incorporación de  un nuevo atributo. Según las siguientes condiciones:
- El atributo se llamará idUsr de tipo String.
- Se debe establecer un procedimiento para generar el idUsr de forma automática en función de otros atributos de la clase. Teniendo en cuenta que:
  - Se utilizará un método llamado generarIdUsr().
  - Se utilizarán tres letras mayúsculas correspondientes a las iniciales del nombre y los apellidos más los dos últimos caracteres del Nif.
- Se deberá proporcionar un método público llamado generarVarianteIdUsr() para poder variar el idUsr para casos en los que se puedan producir coincidencias. La variación consistirá en cambiar la última letra del idUsr inicial con la siguiente en serie del nif.
- Definición de un enumerado anidado en la clase, llamado RolUsuario, para representar los posibles valores del atributo rol.
- Mejora de los métodos para validar. Para la validación de los los atributos de la clase se utilizarán expresiones regulares para la verificación del formato según los siguientes criterios:
  - El método nombreValido(); permirá comprobar si el nombre cumple criterios básicos de un nombre de persona correctamente expresado.
  - El método apellidosValidos(); permirá comprobar si los apellidos cumplen criterios básicos de formato.
  - Redefinir adecuadamente los métodos clone(), hashCode(), equals() y toString().
  - Se deben superar limpiamente todos los tests previstos en la clase UsuarioTest para dar por completado el apartado.

## 8. Modificación de las clases SesionUsuario y Simulacion
- Incorporación, en cada una de las dos clases, de un método para obtiener el idSesion o idSimulacion respectivamente. Según las siguientes condiciones:
  - Los métodos se llamarán getIdSesion() y getIdSimulacion().
  - Devolverán respectivamente un texto del idSesion o del idSimulacion generado. No aparecerán como atributos en las clases.
  - Los respectivos métodos, en cada clase, concatenan el idUsr y una secuencia de digitos correspondiente a la marca de tiempo. La precisión de la marca de tiempo será del orden del segundo.
  - La clase Fecha proporcionará un método llamado toStringMarcaTiempo() para obtener una marca de tiempo.
- Redefinir adecuadamente los métodos clone(), hashCode(), equals() y toString().
- Se deben superar limpiamente todos los tests previstos en la clase SesionUsuarioTest para dar por completado el apartado.

## 9. Implantacion y reubicación del almacen de datos y métodos asociados en la clase Datos.
- Según las siguientes condiciones: (Puede que varias de las características pedidas estén ya hechas en la clase JVPrincipal del prototipo anterior).
- Trasladar los arrays del Almacén de Datos del programa a la clase Datos.
- Crear un nuevo array para las simulaciones que se llame datosSimulaciones
- Definir un método privado llamado cargarDatosUsuariosPrueba().
- Crear dos métodos para hacer un volcado completo de todos los datos sobre una cadena de texto delimitadas con etiquetas; una para usuario y otra para las sesiones de usuario.
  - Se debe utilizar etiquetas <sesion>...</sesion> para delimitar objetos SesionUsuario , <usr>...</usr> para objetos Usuario y <attrib>...</attrib> para los atributos. 
  - Los métodos se llamarán:  volcarDatosUsuariosTexto() y volcarDatosSesionesTexto().
  - Traslada el método público para registrar nuevas sesiones de usuario en el vector datosSesiones.
    - El método se llamarán registrarSesion() y recibirá un objeto SesionUsuario.
  - Traslada o crea los métodos para realizar búsquedas secuenciales dentro de las estructuras de datos.
    - Hay que definir y utilizar un método público específico para cada array de datos. Los métodos se llamarán: buscarUsuario() , buscarSesion(), buscarSimulacion(), buscarSesiones() y buscarSimulaciones().
    - Los métodos buscar...() reciben el id... a buscar y devuelve el objeto encontrado o null si no existe.
    - Los métodos buscarSesiones() y  buscarSimulaciones() reciben el idUsr de las las sesiones o simulaciones a buscar y devuelve un array con los los objetos encontrados o null si no encuentra.
  - Mejora los métodos buscar...() para que utilice el algoritmo de búsqueda binaria.
  - Establece un criterio de almacenamiento en el array de usuarios que mantenga la ordenación basada en el idUsr que no produzca problemas de repetición de datos y sea a su vez suficientemente flexible.
    - Se debe utilizar un método para almacenar, llamado altaUsuario()  que asegure un almacenamiento ordenado para hacer posible la búsqueda binaria.
  - Crea una tabla de equivalencias entre nif, correo y el idUsr realmente utilizado en la búsqueda; esto permitirá la utilización del nif o la dirección de correo como  identificación admitida en el inicio de sesión. Esto se puede resolver con un diccionario o mapa que asocie parejas clave-valor, basado en una tabla hash.

## 10. Reubicación de métodos en la clase Presentacion
- Se deben adaptar los siguientes métodos para que sigan funcionando ubicándolos en la clase Presentacion:
  - inicioSesionCorrecto()
  - mostrarMundo()

## 11. Entrega del código fuente
Una vez completados todos los ejercicios y apartados entrega el código fuente del prototipo1.1 y los ejercicios de práctica básica, teniendo en cuenta que:

  - Conviene hacer una revisión del código fuente de todas las clases del prototipo1.1 y de los ejercicios de práctica básica realizados, comprobando convenciones de escritura de código fuente Java.
  - Hay que comprobar que la documentación interna del código fuente está actualizada y es correcta. 
  - Sólo hay que entregar código fuente. No el resto del proyecto de Eclipse.
