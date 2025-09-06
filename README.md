# 🚖 UberReviewService  

A Spring Boot–based microservice for handling **reviews** in a ride-booking application.  
This service is responsible for **creating, fetching, and deleting reviews** associated with bookings.  

---

## 📌 Features Implemented  

- ✅ Spring Boot project with **Gradle build system**  
- ✅ `Review` entity mapped with `Booking` (Many-to-One)  
- ✅ DTOs for **request** (`CreateReviewDto`) and **response** (`ReviewDto`)  
- ✅ `CreateReviewDtoToReviewAdapter` for converting DTO → Entity  
- ✅ `EntityToReviewDto` for converting Entity → DTO  
- ✅ Review creation API (`POST /reviews`)  
- ✅ Error handling for invalid arguments (handled at **controller side**)  
- ✅ Repository layer for persistence  
- ✅ Service layer with **business logic separation**  
- ✅ Controller layer with clean request/response handling  

---

## 🗂️ Project Structure  

```
UberReviewService/
├── src/main/java/com/example/UberReviewService/
│   ├── adapter/                   # Converters/Adapters
│   │   ├── CreateReviewDtoToReviewAdapter.java
│   │   ├── CreateReviewDtoToReviewAdapterImpl.java
│   │   └── ReviewEntityToDtoAdapter.java (planned)
│   │
│   ├── controllers/               # REST Controllers
│   │   └── ReviewController.java
│   │
│   ├── dtos/                      # Data Transfer Objects
│   │   ├── CreateReviewDto.java
│   │   └── ReviewDto.java
│   │
│   ├── models/                    # Entities
│   │   ├── Review.java
│   │   └── Booking.java
│   │
│   ├── repositories/              # Spring Data JPA Repositories
│   │   ├── ReviewRepository.java
│   │   └── BookingRepository.java
│   │
│   ├── services/                  # Business Logic
│   │   ├── ReviewService.java
│   │   └── ReviewServiceImpl.java
│   │
│   └── UberReviewServiceApplication.java   # Main Spring Boot App
│
└── build.gradle
```

---

## 📜 Endpoints  

### 1. Create Review  
**POST** `/reviews`  

**Request Body (CreateReviewDto):**  
```json
{
  "content": "Driver was polite and ride was smooth",
  "rating": 4.5,
  "bookingId": 101
}
```

**Response (ReviewDto):**  
```json
{
  "id": 1,
  "content": "Driver was polite and ride was smooth",
  "rating": 4.5,
  "booking": 101,
  "createdAt": "2025-09-04T12:30:00Z",
  "updatedAt": "2025-09-04T12:30:00Z"
}
```

**Error Response:**  
```json
{
  "error": "Invalid arguments passed"
}
```

---

## ⚙️ Tech Stack  

- **Java 17+**  
- **Spring Boot 3+**  
- **Gradle** (build tool)  
- **Spring Data JPA** (ORM)  
- **H2 / MySQL** (configurable database)  
- **Lombok** (for boilerplate reduction)  

---

## ▶️ Running the Project  

### 1. Run via Gradle CLI  
```sh
./gradlew bootRun
```

### 2. Run via IntelliJ IDEA  
- Open the project in IntelliJ.  
- Run `UberReviewServiceApplication.main()`.  

---

## 📌 Next Planned Features  

- 🔄 Update review endpoint (`PUT /reviews/{id}`)  
- ❌ Delete review endpoint (`DELETE /reviews/{id}`)  
- 📖 Get review(s) endpoint (`GET /reviews` and `GET /reviews/{id}`)  
- 🧪 Integration tests with JUnit & MockMvc  
- 🌐 API documentation with Swagger  

---

✅ Keep updating this `README.md` as you add new features.  
