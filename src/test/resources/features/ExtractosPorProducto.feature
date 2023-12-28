


@ExtactosPorProducto
Feature: Yo como cliente corporativo quiero descargar mi extracto de productos

#*** 1 ****

  @NoingresoTipoDeProducto
  Scenario Outline: cliente No ingresa Tipo de producto al intentar descargar extracto

    Given Que el cliente se encuentra en el modulo de consultas y extractos en el submodulo Extracto por producto
    And Selecciona el tipo de producto <Cuenta>
    When No seleccione ningun producto
    Then Los botones año y mes del extracto deberian estar inabilitados
    And Al dar click en boton Mostrar datos deberia verse el <MensajeDeError>

    Examples:
      | Cuenta              | MensajeDeError |
      | CUENTA AHORROS BANCO FALABELLA | Seleccione el número del producto.|
      | CUENTA CORRIENTE BANCO FALABELLA | Seleccione el número del producto.|


