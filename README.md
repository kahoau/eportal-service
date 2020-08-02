# eportal-service


## build docker image, upload to docker hub
```
# could install it via intellij 
mvn clean install                

docker build -t kahoau/eportal-service -f ./Dockerfile .  

# push it to the docker repo named eportal-service under my account     
docker login
docker push kahoau/eportal-service:latest
```

## Deploy the application to a local Kubernetes Cluster

### Install a local Kubernetes Cluster (with a single node) on your machine:

For Linux: MicroK8s
For Mac/Windows: A local Kubernetes Cluster can be enabled with the latest versions of Docker for Windows/Mac

### Deploy the application to kubernetes

```
kubectl apply -f deployment.yml

kubectl get deployments
kubectl describe deployments
kubectl get services
kubectl get pods
kubectl get all

curl http://localhost:31000/actuator/health

kubectl delete deploy/eportal-service
kubectl delete service/eportal-service
```



## Deploy to ec2 instance 

### Create a new ec2 instance
Go https://www.youtube.com/watch?v=1fnPCWBikYQ&t=143s

to download the key pair for ssh 

### ssh to ec2
```
chmod 400 eportal-keypair.pem # first time only
ssh -i "eportal-keypair.pem" ec2-user@ec2-54-149-212-13.us-west-2.compute.amazonaws.com
```

### Start docker and the container with the image previously uploaded to docker hub
```
sudo yum update -y          # first time only
sudo yum install docker -y  # first time only
sudo service docker start
sudo docker run -d -p 80:8080 kahoau/eportal-service
```

Go back to aws console, find the base url and open the link in browser
http://ec2-54-149-xxx-yyy.us-west-2.compute.amazonaws.com

### Notes for tearing down the container and image
```
sudo docker ps -aq
sudo docker stop <container_id>
sudo docker rm <container_id>

sudo docker images
docker rmi -f <image_id> 
```


## Reference 
### export pdf by freemarker
https://www.programmersought.com/article/3267527859/

### captcha
https://www.youtube.com/watch?v=wF72t9dSBU8
https://github.com/mightyjava/springboot-captcha-cage

### authentication
https://kknews.cc/code/2y8mrre.html  jwt, spring security
https://www.concretepage.com/spring/spring-security/spring-mvc-security-jdbc-userdetailsservice-database-authentication
https://octoperf.com/blog/2018/03/08/securing-rest-api-spring-security/
