# Tarea 09 - Gestor de descargas

**Módulo:** Programación de servizos e procesos  
**Curso:** CFGS DAM 2 - 2026/2027  
**Alumno:** René Chamorro Crugeiras  

## 1. Descripción

En esta tarea se desarrolla un gestor de descargas utilizando hilos en Java.

Cada archivo se descarga de forma simulada en 10 bloques. Cada bloque tarda un tiempo determinado y las cuatro descargas se ejecutan simultáneamente mediante hilos.

Los archivos utilizados son:

* `cuarzos.png`
* `meditacion.mp4`
* `mantras.mp3`
* `horoscopo.pdf`

## 2. Clases

El programa está formado por:

* `Descarga.java`: simula la descarga de un archivo mediante un hilo.
* `GestorDescargas.java`: contiene el método `main`, crea y ejecuta las descargas y muestra el informe final.

Además, al hacer los diferentes niveles hay que implementar las siguientes clases:

* `Monitor.java`: controla las descargas que están en curso y cada 500ms muestra cuantas siguen activas.
* `Instalador.java`: espera a que terminen `meditacion.mp4` y `mantras.mp3` para poder realizar la instalación, mientras las demás descargas pueden continuar.

## 3. Funcionamiento de la clase Descarga

La clase `Descarga` hereda de `Thread`.

El constructor recibe el nombre del archivo y selecciona aleatoriamente el tiempo que tardará cada bloque, entre 100 y 500 milisegundos.

Se utiliza la constante:

```java
AJUSTE_BLOQUE = 1
```


