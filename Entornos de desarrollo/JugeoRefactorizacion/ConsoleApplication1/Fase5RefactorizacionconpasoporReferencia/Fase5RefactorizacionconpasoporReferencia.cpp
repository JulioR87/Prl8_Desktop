//En esta fase, introducimos estructuras para representar tanto al héroe como al enemigo. 
//Usamos paso por referencia para que las funciones puedan modificar directamente los valores dentro de las estructuras, lo que simplifica el manejo de datos.

#include <iostream>
using namespace std;

// Estructura para representar a un personaje
struct Personaje {
    int vida;
    int ataque;
};

// Declaración de funciones
void heroAttackEnemy(Personaje& enemigo, const Personaje& heroe);
void enemyAttackHero(Personaje& heroe, const Personaje& enemigo);
void printStatus(const Personaje& heroe, const Personaje& enemigo);

int main()
{
    // Inicializamos al héroe y al enemigo
    Personaje heroe = { 100, 20 };   // Vida: 100, Ataque: 20
    Personaje enemigo = { 100, 15 }; // Vida: 100, Ataque: 15

    cout << "¡Comienza el combate entre el héroe y el enemigo!" << endl;

    while (heroe.vida > 0 && enemigo.vida > 0) {
        // El héroe ataca al enemigo
        heroAttackEnemy(enemigo, heroe);
        if (enemigo.vida <= 0) break;

        // El enemigo ataca al héroe
        enemyAttackHero(heroe, enemigo);
        if (heroe.vida <= 0) break;

        // Mostrar el estado actual
        printStatus(heroe, enemigo);
    }

    return 0;
}

// Función para el ataque del héroe
void heroAttackEnemy(Personaje& enemigo, const Personaje& heroe) {
    enemigo.vida -= heroe.ataque; // Se resta el ataque del héroe a la vida del enemigo
    cout << "El héroe ataca y causa " << heroe.ataque << " de daño." << endl;
}

// Función para el ataque del enemigo
void enemyAttackHero(Personaje& heroe, const Personaje& enemigo) {
    heroe.vida -= enemigo.ataque; // Se resta el ataque del enemigo a la vida del héroe
    cout << "El enemigo ataca y causa " << enemigo.ataque << " de daño." << endl;
}

// Función para mostrar el estado actual del combate
void printStatus(const Personaje& heroe, const Personaje& enemigo) {
    cout << "Vida del héroe: " << heroe.vida << ", Vida del enemigo: " << enemigo.vida << endl;
}


//Explicación:
//Estructuras:
//Creamos una estructura llamada Personaje con los atributos vida y ataque.
//Esto permite agrupar los datos relacionados con cada personaje.
//Paso por referencia :
//Usamos & en los parámetros de las funciones(Personaje& enemigo) para que las modificaciones realizadas dentro de la función se reflejen fuera de ella.
//Por ejemplo, si la vida del enemigo cambia en heroAttackEnemy, este cambio es visible en main.
//Funciones :
    //heroAttackEnemy : Reduce la vida del enemigo directamente usando los valores del héroe.
    //enemyAttackHero : Reduce la vida del héroe directamente usando los valores del enemigo.
    //printStatus : Muestra la vida actual de ambos personajes, pero no los modifica.