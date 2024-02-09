


@ExtactosPorProducto
Feature: Yo como cliente corporativo quiero descargar mi extracto de productos

#*** 1 ****



  @DescargarPdf
  Scenario Outline: Cliente descarga su extracto con exito

    Given Que el cliente se encuentra en el modulo de consultas y extractos en el submodulo Extracto por producto
    And Selecciona el tipo de producto <TipoProducto>
    And Selecciona el producto <Producto>
    And Selecciona el ano del extracto <Ano>
    And Selecciona el mes del extracto <Mes>
    When Da click al boton Mostrar Datos
    Then Deberia ver el extracto en la pantalla
    And Al darle click en el boton descargar deberia descargarse el extracto

    Examples:
      | TipoProducto                     |Producto     |Ano |Mes      |
      | CUENTA AHORROS BANCO FALABELLA   |116060084657 |2023|Diciembre|






  @NoSeIngresaronDatos
  Scenario Outline: cliente No ingresa Tipo de producto al intentar descargar extracto

    Given Que el cliente se encuentra en el modulo de consultas y extractos en el submodulo Extracto por producto_
    And Selecciona el tipo de producto_ <TipoProducto>
    And Selecciona el producto_ <Producto>
    When Da click al boton Mostrar Datos_
    Then Deberia verse el error_ <Mensaje>

    Examples:
      | TipoProducto                     |Producto                          |Mensaje                                         |
      | -- SELECCIONE EL TIPO PRODUCTO --|-- SELECCIONE EL TIPO PRODUCTO -- |Debe seleccionar el tipo de producto a consultar|
      | CUENTA CORRIENTE BANCO FALABELLA |-- SELECCIONE EL TIPO PRODUCTO -- |Seleccione el número del producto.              |
      | CUENTA AHORROS BANCO FALABELLA   |116050057245                      |Se ha presentado un error, por favor validar con el siguiente ID: 86697862|
      | CUENTA CORRIENTE BANCO FALABELLA |116050057245                      |146210000014|

