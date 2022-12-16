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

| NFR_01 | Movie Info in SQL|
|----------| ------ | 
| Priority | Medium  |
| Description | We would like to store the movie info in a SQL database|

| NFR_02 | Movie users info in SQL|
|----------| ------ | 
| Priority | Medium  |
| Description | We would like to store the user info in a SQL database|

## No Functional Requirements

| NFR-01 |  Basic movie info |
|----------| ------ | 
| Priority | High |
| Description | Basic movie info should have: Movie title, Release year, user who added the movie, Created at and Updated at |

| NFR-02 | User info |
|----------| ------ | 
| Priority | High |
| Description | User info should have: Username and Email|

## Nice to have!

| NTH-01 | Admin roles |
|----------| ------ | 
| Description | Roles for the Admin (movie update access) and any user (read access and creation access and rating write access)|

| NTH-02 |  Admin spring security roles|
|----------| ------ | 
| Description | Spring Security (roles)|