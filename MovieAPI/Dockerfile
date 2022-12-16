FROM openjdk:11-jre-slim-stretch AS build-env
WORKDIR /app

# Copy everything
COPY . ./
RUN pip install
# Build and publish a release
RUN dotnet publish -c Release -o out

# Build runtime image
FROM mcr.microsoft.com/dotnet/aspnet:6.0
WORKDIR /app
COPY --from=build-env /app/out .
ENTRYPOINT ["dotnet", "app-dotnet.dll"]