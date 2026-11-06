# 电商平台后端（Spring Boot 3 + MyBatis-Plus）

一个覆盖**会员、商品、品牌、商品分类、购物车、收货地址**等核心业务的电商后端服务，共 **30 个 REST 接口**，配套 Knife4j 在线接口文档。

- 技术栈：Spring Boot 3.5.5 · JDK 17 · MyBatis-Plus 3.5.7 · MySQL 8.0 · Redis · JWT · PageHelper · Knife4j
- 数据库：`shopping_mall`，共 10 张表（见 [`schema.sql`](schema.sql)，**仅表结构，不含任何业务数据**）
- 接口文档：启动后访问 `http://localhost:8080/doc.html`

> 表结构沿用开源商城项目 `mall` 的业务模型（`pms_` / `oms_` / `ums_` 前缀）；[`schema.sql`](schema.sql) 由本项目实际使用的 10 张表导出。

---

## 一、功能模块

| 模块 | Controller | 接口数 | 说明 |
|---|---|---:|---|
| 会员登录 | `UmsMemberController` | 1 | 账号密码登录，返回会员信息（密码脱敏） |
| 会员收货地址 | `UmsMemberReceiveAddressController` | 2 | 按会员查询地址列表，含 Redis 缓存版本 |
| 商品管理 | `PmsProductController` | 6 | 分页查询、详情、新增、修改、删除，含主图/详情图 |
| 商品列表 | `GoodsController` | 8 | 全量/条件查询、分页（PageHelper）、增删改 |
| 品牌 | `PmsBrandController` | 1 | 品牌列表 |
| 商品分类 | `PmsProductCategoryController` | 1 | 树形分类节点（父子结构递归组装） |
| 购物车 | `OmsCartItemController` | 2 | 加入购物车、按会员查询购物车列表 |
| 后台用户 | `SysUserController` | 3 | 用户列表、按条件查询、全量查询 |
| 客户资料 | `CustomerController` | 6 | 分页、分组统计、新增/更新 |

## 二、目录结构

```
src/main/java/com/cafuc/shopping
├── bean/          # 实体类（MyBatis-Plus @TableName 映射）
├── common/        # 统一返回结构 CommonResult / ResultCode
├── config/        # MyBatis-Plus、Redis、Knife4j、MyBatis 二级缓存配置
├── controller/    # REST 接口层
├── mapper/        # Mapper 接口
├── service/       # Service 接口与实现
└── util/          # JwtUtil（token 签发与校验）
src/main/resources
├── application.yml
└── mapper/        # MyBatis XML
schema.sql         # 建表语句（10 张表，无数据）
```

## 三、快速开始

**环境要求**：JDK 17、Maven 3.8+、MySQL 8.0、Redis 5+

```bash
# 1. 导入数据库（会自动创建 shopping_mall 库）
mysql -u root -p < schema.sql

# 2. 配置连接信息：可直接改 application.yml，或用环境变量覆盖
#    DB_HOST / DB_PORT / DB_NAME / DB_USERNAME / DB_PASSWORD / REDIS_HOST / REDIS_PORT / JWT_SECRET

# 3. 启动
mvn spring-boot:run

# 4. 接口文档
#    http://localhost:8080/doc.html
```

> 只打包不跑测试：`mvn clean package -DskipTests`
> 仓库内的 `@SpringBootTest` 用例需要本地 MySQL 与 Redis 已启动。

## 四、实现要点

- **分层结构**：Controller → Service → Mapper，实体由 MyBatis-Plus 注解映射表字段，常规 CRUD 走 `BaseMapper`，复杂查询用 `QueryWrapper` 或 XML 手写 SQL。
- **分页**：商品列表使用 PageHelper（`PageHelper.startPage` + `PageInfo`），商品/客户分页使用 MyBatis-Plus `Page` 插件，两种方案均在代码中落地。
- **缓存**：`RedisService` 基于 `StringRedisTemplate` 封装（set/get/expire/increment）；`MybatisRedisCache` 实现 MyBatis `Cache` 接口，可通过 `@CacheNamespace` 接管二级缓存；收货地址查询提供带缓存与不带缓存两个接口，便于对比缓存命中效果。
- **鉴权**：`JwtUtil` 基于 `java-jwt` 封装 token 的签发与校验（含过期时间、签名算法），签名密钥从 `jwt.secret` 读取（环境变量 `JWT_SECRET` 覆盖），不在代码中硬编码。
- **接口文档**：Knife4j（OpenAPI 3）自动生成，随代码注解同步。

## 五、已知问题与改进方向

项目在开发期以「跑通业务流程」为目标，以下问题已在自测中记录，也是后续重构的方向：

1. **购物车水平越权**：`/omsCartItem/list` 的 `memberId` 由前端参数传入且允许为空，为空时不加过滤条件直接返回全表，也未与登录身份绑定；应改为从 token 解析会员身份。
2. **登录安全**：会员登录为明文密码比对，未使用 BCrypt；`JwtUtil` 已封装但尚未接入登录与拦截器链路。
3. **返回结构不统一**：仅会员登录使用 `CommonResult`，其余接口直接返回实体或 `Map`，前端需要按接口分别处理。
4. **查询存在 N+1**：商品分页会在循环中逐条查询主图/详情图，数据量增大后需要改为批量查询或关联查询。
5. **缺少参数校验与全局异常处理**：非法参数依赖数据库报错兜底，错误码语义不清晰。
6. **无自动化测试**：接口验证依赖手工 Postman 用例，尚未接入 JUnit + MockMvc 与 CI。

## 六、说明

- `schema.sql` 通过 `mysqldump --no-data` 导出，只保留建表语句，**不包含任何用户数据**。
- `application.yml` 中的数据库、Redis、JWT 配置均使用环境变量占位符，默认值仅用于本地启动。
