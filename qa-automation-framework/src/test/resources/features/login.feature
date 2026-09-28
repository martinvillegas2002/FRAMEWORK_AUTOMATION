
Feature: Acceso a la tienda virtual de pruebas

  Scenario Outline: Validar que la página carga correctamente
    Given el usuario ingresa a la pagina con el usuario "<usuario>"
    And ingresa la contraseña "<contraseña>"
  #  Then el titulo de la pestaña debe mostrar el texto esperado

    Examples:

    |usuario                 | contraseña |
    |admin@ahorr-e.com       | admin123   |


