# Benim İlk Mikroservis Projem

Bu proje, mikroservis mimarisi ile geliştirilen bir kimlik doğrulama ve kullanıcı yönetim sistemi sunmaktadır. Proje, Google Cloud üzerinde Docker ve Kubernetes kullanılarak dağıtılmıştır.

## İçindekiler

- [Genel Bakış](#genel-bakış)
- [Teknolojiler](#teknolojiler)
- [Kurulum](#kurulum)
- [Kullanım](#kullanım)
- [Yapılandırma](#yapılandırma)

## Genel Bakış

Bu proje, iki mikroservis içermektedir:

1. **Auth Servisi**: Kullanıcı kayıt işlemlerini yönetir. PostgreSQL veri tabanına bağlıdır.
2. **User Servisi**: Kullanıcı giriş işlemlerini yönetir. MongoDB veri tabanına bağlıdır.

## Teknolojiler

Bu projede kullanılan başlıca teknolojiler şunlardır:

- **Java & Spring Boot**: Mikroservisleri geliştirmek için kullanıldı.
- **PostgreSQL**: Auth servisi için veri tabanı olarak kullanıldı.
- **MongoDB**: User servisi için veri tabanı olarak kullanıldı.
- **Docker**: Mikroservislerin imajlarını oluşturmak için kullanıldı.
- **Kubernetes**: Google Cloud üzerinde mikroservisleri dağıtmak için kullanıldı.

## Kurulum

### Gereksinimler

- Docker
- Kubernetes
- Google Cloud hesabı

### Adımlar

1. Projeyi klonlayın:
   ```bash
   git clone https://github.com/SelahattinGngr/your-repo-name.git
   ```
2. Her mikroservis için Docker imajlarını oluşturun ve Google Container Registry'ye pushlayın.

3. Kubernetes cluster'ını oluşturun ve mikroservislerinizi deploy edin.

### Kullanım

Auth servisi kayıt işlemlerini, User servisi ise giriş işlemlerini yönetir. Her bir servisi test etmek için uygun API endpoint'lerine istek gönderebilirsiniz ve ya url:port/swagger-ui/index.html adresine giderek Swagger arayüzünü kullanabilirsiniz.

### Yapılandırma

MongoDB başlatıldıktan sonra aşağıdaki ayarın yapılması gerekmektedir:

```
db.createUser({user: "selahattin",pwd: "root",roles: ["readWrite","dbAdmin"]})
```
