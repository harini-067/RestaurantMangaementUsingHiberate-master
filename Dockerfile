# Step 1: Use official Java 17 image
FROM eclipse-temurin:17-jdk-jammy

# Step 2: Set working directory inside the container
WORKDIR /app

# Step 3: Copy your JAR into the container
COPY out/artifacts/RestaurantManagementUsingHibernate/RestaurantManagementUsingHibernate.jar App.jar
# Step 4: Set environment variables for DB config (optional)
ENV DB_URL=jdbc:mysql://localhost:3306/restaurantManagement
ENV DB_USER=root
ENV DB_PASS=harini

# Step 5: Run the JAR
CMD ["java", "-jar", "App.jar"]
