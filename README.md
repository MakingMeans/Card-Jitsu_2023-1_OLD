# Card-Jitsu-PRF_FUNDPGR_20231
![icon](https://github.com/MakingMeans/Card-Jitsu-PRF_FUNDPGR_20231/assets/117835098/dc698324-2281-4bd6-b62c-d41a5626bb75)

> [2023-1 Proyecto Final FP.pdf](https://github.com/MakingMeans/Card-Jitsu-PRF_FUNDPGR_20231/files/11438667/2023-1.Proyecto.Final.FP.pdf).

Trabajen :) *los azota fuertemente*

**COSAS POR HACER**
+ Llamar el comando save y load Data en donde se necesite.
+ Los metodos que devuleven deben devolverse solo mediante breaks; o return; NO CON OTRAS FUNCIONES!
+ Organizar las ventanas como dice Valeria.
+ Aprender a hacer timers.
+ Aprender a explicar la data.
+ Crear modo USER vs USER.

**Lista de Contenidos**
+ CONTROLADOR
  + AplMain: Llama al controller.
  + Controlador: Ejecuta las funciones principales.
+ MODELOS
  + Carta: Contine 3 atributos (elemento, numero, color).
  + Mazo: Contiene 30 cartas.
  + User: Contine 3 atributos (nombre, puntaje, id).
  + Gameplay: Mecanicas principales de juego.
  + Data: Ejecuta y controla los mecanismos de carga y guardado de la data de usuario.
  + VentanaPrincipal: Contiene las funciones primarias.
  + VentanaSecundaria: Contiene las funciones secundarias.
+ VISTA
  + Interfaz (Aun no): Ambiente gráfico.

### Tablas
| Obj  | Cantidad |
| ------------- | ------------- |
| Cartas  | 256  |
| Mazos  | 2  |

| Function name | Description                    |
| ------------- | ------------------------------ |
| `c.ejecutar()`      | Ejecuta todo dentro del main.       |
| `<name>.test()`   | **Se eliminara en el futuro!** Solo para testeo.     |

#### Java　

```java
public class AplMain {
	public static void main(String args[]) {
		Controller c=new Controller();
		c.ejecutar();
	}
}
```
