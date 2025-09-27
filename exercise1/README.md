## Implemented Patterns and Use Cases

### 1. Behavioral Patterns

#### Observer Pattern – University Alert System

* **Use case:** A university alert system that notifies students, faculty, and administrators about alerts such as events, emergencies, or announcements.
* **Why Observer:** Alerts should automatically reach all registered members without tightly coupling the sender and receivers.
* **Demo:** Users can register observers (student, faculty, admin) and send alerts. Observers receive notifications based on their subscription.

#### Strategy Pattern – Vehicle Operational Modes

* **Use case:** A vehicle that can switch between different modes: Economy, Sport, and Comfort.
* **Why Strategy:** Operational behavior should be changeable at runtime without altering the vehicle class.
* **Demo:** User selects and switches strategies dynamically to observe different vehicle behaviors.

---

### 2. Creational Patterns

#### Singleton Pattern – Centralized Voting System

* **Use case:** A voting system where only one global instance should manage votes to avoid data inconsistency.
* **Why Singleton:** Ensures a single point of truth across the application.
* **Demo:** Multiple attempts to create voting system instances always return the same object. Votes are tracked globally.

#### Factory Pattern – AI Model Factory

* **Use case:** A system that produces different AI models (e.g., GPT, BERT, Vision Model) depending on the requested task.
* **Why Factory:** Encapsulates object creation and allows easy extension for new models.
* **Demo:** User requests a model by type, and the factory instantiates the appropriate class without exposing creation logic.

---

### 3. Structural Patterns

#### Decorator Pattern – Online Learning Badges

* **Use case:** An online learning platform where students can earn badges such as “Java Pro”, “AI Expert”, and “Top Performer”.
* **Why Decorator:** Allows dynamic addition of new features (badges) to a student without modifying the base class.
* **Demo:** Student objects are decorated interactively with badges, demonstrating flexible runtime composition.

#### Proxy Pattern – Enhanced Large Dataset Loader

* **Use case:** Loading and displaying large datasets on demand.
* **Why Proxy:** Provides a lightweight placeholder that controls access to the real dataset.
* **Features implemented:**

  * Lazy loading (load dataset only on first use)
  * Caching (reuse already loaded dataset)
  * Access control (only admin role can access data)
  * Logging (all access attempts are recorded)
* **Demo:** Users interact with the dataset through a proxy, observing delayed loading, cached access, restricted roles, and logging.

---

## How to Run

1. Clone the repository

   ```bash
   git clone <repo-link>
   cd design-patterns-exercise
   ```

2. Compile the code (Java example)

   ```bash
   javac exercise1/**/**/*.java
   ```

3. Run any demo. For example:

   ```bash
   java exercise1.behavioral.observer.ObserverDemo
   java exercise1.behavioral.strategy.StrategyDemo
   java exercise1.creational.singleton.SingletonDemo
   java exercise1.creational.factory.FactoryDemo
   java exercise1.structural.decorator.DecoratorDemo
   java exercise1.structural.proxy.ProxyDemo
   ```

---

