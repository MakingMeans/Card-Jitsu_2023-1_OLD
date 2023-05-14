# Card-Jitsu-PRF_FUNDPGR_20231
![icon](https://github.com/MakingMeans/Card-Jitsu-PRF_FUNDPGR_20231/assets/117835098/dc698324-2281-4bd6-b62c-d41a5626bb75)

> [2023-1 Proyecto Final FP.pdf](https://github.com/MakingMeans/Card-Jitsu-PRF_FUNDPGR_20231/files/11438667/2023-1.Proyecto.Final.FP.pdf).

Trabajen :) *los azota fuertemente*

**COSAS POR HACER**
+ Sistema de victoria usando color y elemento.
+ Sistema de puntaje y cinturon.
+ Probablemente agregar el mazo del usuario como uno de sus parametros
  + Es decir usuarios[i]=new User(String, int, byte, Carta[]);
  + NO ES NECESARIO, SOLO UNA POSIBILIDAD (por ahora)
+ Data de usuario despues de cierre.

**Lista de Contenidos**
+ CONTROLADOR
  + AplMain: Llama al controller.
  + Controlador: Ejecuta las funciones principales.
+ MODELOS
  + Carta: Contine 3 atributos (elemento, numero, color).
  + Mazo: Contiene 30 cartas.
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
