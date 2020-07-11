# Spring data jpa hibernate and postgres

## postgres
- version 11
- for installing postgres in virtual machine refer to vagant project: https://github.com/mohalaoui/vagrant
- spring config:

<pre><code>
server.port=7000
spring.datasource.url=jdbc:postgresql://192.168.5.8:5432/dev
spring.datasource.username=vagrant
spring.datasource.password=vagrant
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
</code></pre>

## hibernate
- spring config
<pre><code>
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update
</code></pre>
## ehcache
- enable caching : @EnableCaching(mode = AdviceMode.ASPECTJ)
- caching entities : @Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "product")
- spring config

<pre><code>
spring.jpa.properties.hibernate.cache.use_second_level_cache=true
spring.jpa.properties.hibernate.cache.use_query_cache=true
spring.jpa.properties.hibernate.cache.region.factory_class=org.hibernate.cache.ehcache.EhCacheRegionFactory
spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
</code></pre>

- ehcache.xml
  - set the default cache policy
  - add custom cache policy by region
- example:
<pre><code>
<defaultCache eternal="false" timeToLiveSeconds="30"
memoryStoreEvictionPolicy="LRU" statistics="true" maxElementsInMemory="10000"
overflowToDisk="false" />

<cache name="product" maxEntriesLocalHeap="10000" eternal="false"
timeToIdleSeconds="60" timeToLiveSeconds="60" memoryStoreEvictionPolicy="LRU"
statistics="true">
</cache>

</code></pre>

## HATEOAS

- dependency:
<pre><code>
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>
</code></pre>

- adding link to resource:
  - ResourceRepresentation that extends RepresentationModel<ResourceRepresentation<T>>
  - adding link: customersRepresentation.add(linkTo(methodOn(ShopControllerImpl.class).getCustomers()).withSelfRel());


 



