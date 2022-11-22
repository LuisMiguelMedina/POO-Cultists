# Requirements

## Scope and limitations of the project 
### Scope
1. We would like to have a basic CRUD REST API for a movie fan project

### Limitations 
We can only use the following stack of technologies as the main technologies for the project development:
1. Spring Boot
2. Hibernate (DB access)
3. Docker
4. Junit (Testing)
5. Gradle

## Functional Requirements

| NFR_01 ||
|----------| ------ | 
| Priority | Medium  |
| Description | We would like to store the movie info in a SQL database|

| NFR_02 ||
|----------| ------ | 
| Priority | Medium  |
| Description | We would like to store the user info in a SQL database|

## No Functional Requirements

| NFR-01 ||
|----------| ------ | 
| Priority | High |
| Description | Basic movie info should have: Movie title, Release year, user who added the movie, Created at and Updated at |

| NFR-02 ||
|----------| ------ | 
| Priority | High |
| Description | User info should have: Username and Email|

## Nice to have!

| NTH-01 ||
|----------| ------ | 
| Description | Roles for the Admin (movie update access) and any user (read access and creation access and rating write access)|

| NTH-02 ||
|----------| ------ | 
| Description | Spring Security (roles)|