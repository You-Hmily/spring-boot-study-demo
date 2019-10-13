#Spring In Action---Spring实战
##一、Spring之旅
###1、简化Java开发
###2、容纳你的Bean
###3、俯瞰Spring风景线
###4、Spring的新功能
##二、装配Bean
###2.1、Spring配置的可选方案
    Spring具有非常大的灵活性，它提供了三种主要的装配机制。
    1、在XML文件中进行显示配置
    2、在Java中进行显示配置
    3、隐式的bean发现机制和自动装配。
###2.2、自动化装配Bean
    Spring从两个角度来实现自动化配置
       1、组件扫描（component scanning）：Spring会自动发现应用上下文中所创建的bean。
       2、自动装配（autowiring）：Spring满足bean之间的依赖。
       
    1、创建可被发现的Bean
       CompactDisc接口
       public interface CompactDisc {
           void play();
       }
       带有@Component注解的CompactDisc实现类SgtPeppers
       @Component
       public class SgtPeppers implements CompactDisc{
       
           private String title="Sgt.Pepper's Lonely Hearts Club Band";
           private String artist="The Beatles";
       
           public void play() {
               System.out.printf("Playing %s by %s \n",title,artist);
           }
       }
       @ComponentScan注解启用了组件扫描
       @ComponentScan
       public class CDPlayerConfig {
       
       }
       测试组件扫描能发现CompactDisc
       @RunWith(SpringJUnit4ClassRunner.class)
       @ContextConfiguration(classes= CDPlayerConfig.class)
       public class CDPlayerTest {
       
           @Autowired
           private CompactDisc cd;
       
           @Test
           public void cdShouldNotNull(){
               assertNotNull(cd);
           }
       
       }
    2、为组件扫描的Bean命名
       @Component("lonelyHeartsClub")
       public class SgtPeppers implements CompactDisc{...}
       
       @Named("lonelyHeartsClub")
       public class SgtPeppers implements CompactDisc{...}
    
    3、设置组件扫描的基础包
       @Configuration
       @ComponentScan("soundsystem")
       public class CDPlayerConfig{...}
       
       @Configuration
       @ComponentScan(basePackages="soundsystem")
       public class CDPlayerConfig{...}
       
       @Configuration
       @ComponentScan(basePackageClasses={CDPlayer.class,DVDPlayer.class})
       public class CDPlayerConfig{...}
    
    4、通过为Bean添加注解实现自动装配   
    @Autowired可以用在构造器上，方法上。
     
    @Component
    public class CDPlayer implements MediaPlayer{
        
        private CompactDisc cd;
    
        @Autowired
        public CDPlayer(CompactDisc cd) {
            this.cd = cd;
        }
    
        public void play() {
            cd.play();
        }
    
        @Autowired
        public void setCd(CompactDisc cd) {
            this.cd = cd;
        }
    
        @Autowired
        public void insertDisc(CompactDisc cd){
            this.cd=cd;
        }
    
    }
    
    @Named
    public class CDPlayer implements MediaPlayer{
         @Inject
         public CDPlayer(CompactDisc cd) {
               this.cd = cd;
         }
    }          
    
    5、验证自动装配
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes= CDPlayerConfig.class)
    public class CDPlayerTest {
    
        @Autowired
        private MediaPlayer player;
    
    
        @Autowired
        private CompactDisc cd;
    
        @Test
        public void cdShouldNotNull(){
            assertNotNull(cd);
        }
    
        @Test
        public void play(){
            player.play();
            assertEquals("123","123");
        }
    
    }
    
###2.3通过Java代码装配bean
    1、 创建配置类和声明简单bean、借助JavaConfig实现注入
        @Configuration
        public class CDPlayerConfig {
        
            @Bean("lonelyHeartsClub")
            public CompactDisc setPeppers(){
                return new SgtPeppers();
            }
        
            @Bean
            public CompactDisc randomHeartsClubBand(){
                return new SgtPeppers();
            }
            
            @Bean
            public CDPlayer cdPlayer(){
                return new CDPlayer(setPeppers());
            }
        
            @Bean
            public CDPlayer anotherCDPlayer(){
                return new CDPlayer(setPeppers());
            }
        }
     
###4、通过XML 装配 bean
    1、创建XML规范
       <?xml version="1.0" encoding="UTF-8"?>
       <beans xmlns="http://www.springframework.org/schema/beans"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xmlns:aop="http://www.springframework.org/schema/aop"
              xmlns:context="http://www.springframework.org/schema/context"
              xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
              http://www.springframework.org/schema/aop
              http://www.springframework.org/schema/aop/spring-aop-3.0.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
       
              <context:component-scan base-package="soundsystem" />
       
       </beans>
    2、声明一个简单的bean
       <bean id="compactDisc" class="soundsystem.SgtPeppers"/>
    3、借助构造器注入初始化bean
       <bean id="cdPlayer" class="soundsystem.CDPlayer">
           <constructor-arg ref="compactDisc"/>
       </bean>
       c-命名空间是在Spring 3.0 之后引入，它是在XML中更为简洁地描述构造器参数的方式。
       <bean id="cdPlayer" class="soundsystem.CDPlayer" c:cd-ref="compactDisc" />
       其中c为命名空间前缀，cd 为构造器参数名， -ref为注入bean引用，compactDisc为要注入bean的ID.
       将字面量注入到构造器中：
       public class BlankDisc implements CompactDisc{
       
           private String title;
       
           private String artist;
       
           public BlankDisc(String title, String artist) {
               this.title = title;
               this.artist = artist;
           }
       
           public void play() {
               System.out.printf("Playing %s by %s \n",title,artist);
           }
           
       }
              <!--使用constructor-arg 注入-->
              <bean id="compactDisc" class="soundsystem.BlankDisc" >
                 <constructor-arg value="Sgt.Pepper's Lonely Hearts Club Band"/>
                 <constructor-arg value="The Beatles"/>
              </bean>
              <!--引用构造器参数的名字-->
              <bean id="compactDisc" class="soundsystem.BlankDisc"
                    c:title="Sgt.Pepper's Lonely Hearts Club Band"
                    c:artist="The Beatles"
              />
              <!--通过参数索引装配相同的字面量值-->
              <bean id="compactDisc" class="soundsystem.BlankDisc"
                    c:_0="Sgt.Pepper's Lonely Hearts Club Band"
                    c:_1="The Beatles"
               />
        装配集合
        <bean id="compactDisc" class="soundsystem.BlankDisc" >
               <constructor-arg value="Sgt.Pepper's Lonely Hearts Club Band"/>
               <constructor-arg value="The Beatles"/>
               <constructor-arg>
                   <list>
                       <!--注入数值或者字符-->
                       <value>123</value>
                       <!--注入对象-->
                       <ref bean="beanId" />
                   </list>
               </constructor-arg>
        </bean>         
    4、设置属性
       类：
          public class CDPlayer implements MediaPlayer{
          
              private CompactDisc cd;
          
              @Autowired
              public CDPlayer(CompactDisc cd) {
                  this.cd = cd;
              }
          
              public void play() {
                  cd.play();
              }
          
              @Autowired
              public void setCd(CompactDisc cd) {
                  this.cd = cd;
              }
          
              @Autowired
              public void insertDisc(CompactDisc cd){
                  this.cd=cd;
              }
          }
       属性设置：
               <!--property 元素属性-->    
               <bean id="cdPlayer" class="soundsystem.CDPlayer">
                   <property name="cd" ref="compactDisc"/>
               </bean>
               
               <!--p 命名空间-->
               <bean id="cdPlayer" class="soundsystem.CDPlayer" p:cd-ref="compactDisc"/>          
               p命名空间的组成：p为命名空间前缀，cd为属性名，-ref为bean引用，compactDisc为所注入beanId。
        将字面量注入到属性中
            public class BlankDisc implements CompactDisc{
            
                private String title;
            
                private String artist;
                
                private List<String> tracks;
            
                public BlankDisc(String title, String artist) {
                    this.title = title;
                    this.artist = artist;
                }
            
                public void play() {
                    System.out.printf("Playing %s by %s \n",title,artist);
                }
            
                public BlankDisc(String title, String artist, List<String> tracks) {
                    this.title = title;
                    this.artist = artist;
                    this.tracks = tracks;
                }
            }
            <!--property-->
            <bean id="compactDisc" class="soundsystem.BlankDisc">
                <property name="title" value="Sgt. Pepper's Lonely Hearts Club Band"/>
                <property name="artist" value="The Beatles"/>
                <property name="tracks">
                    <list>
                        <value>123</value>
                    </list>
                </property>
            </bean>
            <!--p 命名空间-->
            <bean id="compactDisc" class="soundsystem.BlankDisc"
                        p:title="Sgt. Pepper's Lonely Hearts Club Band"
                        P:artist="The Beatles">
                <property name="tracks">
                    <list>
                        <value>123</value>
                    </list>
                </property>
            </bean>
            <!--使用util：list-->
            <bean id="compactDisc" class="soundsystem.BlankDisc"
                  p:title="Sgt. Pepper's Lonely Hearts Club Band"
                  p:artist="The Beatles"
                  p:tracks-ref="trackList" >
            </bean>
            <util:list>
                <value>123</value>
            </util:list>   
###5、导入和混合配置
       1、JavaConfig中引用xml
          @Configuration
          @Import(CDPlayerConfig.class)
          @ImportResource("classpath:cd-config.xml")
          public class SoundSystemConfig{
          }     
       2、在XML中引用JavaConfig
              <bean class="soundsystem.CDPlayerConfig"/>
              <import resource="applicationContext.xml"/>                      
##三、高级装配
###1、环境与profile
###2、