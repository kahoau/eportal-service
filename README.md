# eportal-service


## build docker image, upload to docker hub
```
mvn clean install                      # via intellij 
docker build -t kahoau/eportal-repo -f ./Dockerfile .  # rick au's docker hub



docker login
docker push kahoau/eportal-repo:latest
```

## create a new ec2 instance 
https://www.youtube.com/watch?v=1fnPCWBikYQ&t=143s
download the key pair for ssh 

## ssh to ec2
```
chmod 400 eportal-keypair.pem # first time only
ssh -i "eportal-keypair.pem" ec2-user@ec2-54-149-212-13.us-west-2.compute.amazonaws.com
```

## start the container
```
sudo yum update -y          # first time only
sudo yum install docker -y  # first time only
sudo service docker start
sudo docker run -d -p 80:8080 kahoau/eportal-repo
```

## update the container
```
sudo docker ps -aq
sudo docker stop <container_id>
sudo docker rm <container_id>

sudo docker images
docker rmi -f <image_id> 
sudo docker run -d -p 80:8080 kahoau/eportal-repo
```

## login page
http://ec2-54-149-xxx-yyy.us-west-2.compute.amazonaws.com/login


## reference 
### export pdf by freemarker
https://www.programmersought.com/article/3267527859/

### captcha
https://www.youtube.com/watch?v=wF72t9dSBU8
https://github.com/mightyjava/springboot-captcha-cage
