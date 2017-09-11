# BadmintonCourtBill
2017 ThoughtWorks code work

######项目结构简单描述 项目共分为四个模块，并分别对应四个接口和四个实现类，具体如下：

1、流程控制模块，对应接口（\src\main\java\com\tw\Controller.java），主要功能：控制整个项目的流程。

2、输入模块，对应接口（```\src\main\java\com\tw\service\input\InputService.java```），主要功能：将用户输入转化成订单类，并检查输入格式是否合法，输入日期时间格式是否合法

3、处理模块，对应接口（```\src\main\java\com\tw\service\process\ProcessService.java```），主要功能：将输入模块传入的Order类，按照是否是取消订单计算预订费用或违约金，并返回一个是否执行成功的状态（0：表示预订或违约金费用计算成功，1：表示预订订单时发生冲突，2：表示取消订单是未找到预订该订单的记录

4、输出模块，对应接口（```\src\main\java\com\tw\service\ouput\OutputService.java```），主要功能：将经过处理后的Court类处理得到输出字符串

######四个接口分别对应了三个单元测试和一个集成测试，具体如下：
1、流程控制模块对应的是一个集成测试（```\src\test\java\com\tw\controller\CourtControllerTest.java```)对整个项目的进行了集成测试，对原始的输入到最后的输出统一进行了测试。
2、输入模块、处理模块和输出模块分别对应着三个单元测试，对输入的格式、价格的计算和最后的输出字符串分别进行了具体的测试，对应的类在（```\src\test\java\com\tw\service```）。

######利用git项目管理工具对项目进行小步提交管理
github地址：https://github.com/sugarliu33/BadmintonCourtBill.git

######使用trival CI 进行了集成测试
在控制台输入：
```./gradlew clean build```

对项目进行集成测试







