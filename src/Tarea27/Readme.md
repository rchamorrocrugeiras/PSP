# Práctica UDP - Palabra más larga

## Formato de comunicación utilizado

He elegido utilizar cadenas de texto para intercambiar los datos.

- Las palabras se envían separadas por comas.
- La respuesta del servidor contiene la palabra más larga,
  seguida de un punto y coma y su longitud.

Ejemplo de envío:

```hola,programacion,java,ordenador```

Ejemplo de respuesta:

```programacion;12```

## Comunicación

- Protocolo: UDP.
- Puerto del servidor: 5000.
- Tiempo máximo de espera: 2 segundos.
- Número máximo de intentos: 3.

## Ejecución

1. Ejecutar primero ServidorUDP.java.
2. Ejecutar ClienteUDP.java.
3. Introducir varias palabras separadas por comas.
4. El servidor devolverá la palabra más larga y su longitud.

Si el servidor no responde después de los tres intentos,
el cliente mostrará el mensaje "Servidor no disponible".
