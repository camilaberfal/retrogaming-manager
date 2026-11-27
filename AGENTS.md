# RetroGaming Manager

- Configura las propiedades visuales estáticas de Swing (fuentes, colores, bordes, imágenes y tamaños) en **Design** de NetBeans o en el archivo `.form`. El `.form` es la fuente de verdad del diseño.
- Mantén esas asignaciones dentro del bloque plegado **Generated Code** que sincroniza el formulario con Java. Evita duplicarlas en constructores, métodos auxiliares u otras secciones editables de **Source**. Reserva esas secciones para la lógica y los valores que se calculan al ejecutar el formulario.

## Diseño aprobado del login y el menú

Usa `Login.form` y `MenuPrincipal.form` como referencia visual al adaptar las demás ventanas. Conserva el diseño de estas dos pantallas salvo que la usuaria pida cambiarlo.

- **Estilo común.** Tipografía Poppins incluida en `src/fuentes/`, fondos oscuros VHS/CRT, texto crema `#FCF5E0` y acentos amarillos `#FDD818`.
- **Login.** `fondo-login-crt.png` contiene el logo, las líneas de barrido y el halo de **Ingresar**. Etiquetas crema en Poppins Medium 14, campos crema claro `#FBEDC5` en Poppins Regular 13 y botón amarillo con texto oscuro en Poppins SemiBold 14.
- **Menú principal.** Fondo `bg-pequeno.png` de 457 × 333 px en un `JLabel` detrás del contenido, en `(0, 0)` y con tamaño preferido. `pack()` ajusta el interior de la ventana al fondo y el panel de botones es transparente. Bienvenida crema en Poppins SemiBold 21 y rol amarillo en Poppins Medium 13.
- **Botones del menú.** Dos columnas que se ajustan a las opciones visibles de cada rol. Botones de 196 × 38 en Poppins SemiBold 13, con fondo carbón `#191816`, texto crema y `SoftBevelBorder` elevado. **Cerrar sesión** usa texto amarillo sobre fondo `#2E260C`. Replica ese borde en los demás formularios.
