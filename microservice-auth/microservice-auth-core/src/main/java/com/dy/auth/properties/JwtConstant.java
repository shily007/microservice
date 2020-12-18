package com.dy.auth.properties;

public class JwtConstant {

	// 秘钥
	public static final String JWT_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsic3ByaW5nLWJvb3"
			+ "QtYXBwbGljYXRpb24iXSwidXNlcl9uYW1lIjoibGVmdHNvIiwic2NvcGUiOlsicmVhZCJdLCJyb2xlcyI6W3siYXV0aG9yaXR5IjoiUk9MRV"
			+ "9VU0VSIn1dLCJleHAiOjE0OTENTkerDte345EGFXJOYW1lIjoibGVmdHNvIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6Ij"
			+ "gxNjI5NzQwLTRhZWQtNDM1Yy05MmM3LWZhOWIyODk5NmYzMiIsImNsaWVudF9pZCI6Im5vcm1hbC1hcHAifQ.YhDJkMSlyIN6uPfSFPbfRuu"
			+ "fndvylRmuGkrdprUSJIMretgerDFGFDS";

	/**
	 * 加密盐值
	 */
	public static final String JASYPT_ENCRYPTOR_PASSWORD = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsic3ByaW5nLWJvb3"
			+ "QtYXBwbGljYXRpb24iXSwidXNlcl9uYW1lIjoibGVmdHNvIiwic2NvcGUiOlsicmVhZCJdLCJyb2xlcyI6W3siYXV0aG9yaXR5IjoiUk9MRV"
			+ "9VU0VSIn1dLCJleHAiOjE0OTENTkerDte345EGFXJOYW1lIjoibGVmdHNvIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6Ij"
			+ "gxNjI5NzQwLTRhZWQtNDM1Yy05MmM3LWZhOWIyODk5NmYzMiIsImNsaWVudF9pZCI6Im5vcm1hbC1hcHAifQ.YhDJkMSlyIN6uPfSFPbfRuu"
			+ "fndvylRmuGkrdprUSJIMretgerDFGFDS";
	/**
	 * 需要解密的参数
	 */
	public static final String[] NEED_DECRYPT_PARAMS = { "password", "datapwd", "newPassword" };

	/**
	 * 公钥的key
	 */
	public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCtCyoI3WPAxwEbfr9Mcygz0OCx28eEN828Mb3KkVXdsBl2iZvAqsxNAISc71Ow0E"
			+ "A39Okf+eulDj/ajsOxdS44jyLK0Pw4zlX+x6O1Dspek0SPqmL/Py2DA1EiRbFG+GKQSjYG5qtNQSSHPkMmHwI8zrkYkVhgm9N+MSidTWGuXwIDAQAB";

	/**
	 * 私钥的key
	 */
	public static final String PRIVATE_KEY = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAK0LKgjdY8DHARt+v0xzKDPQ4LHbx4Q3zbwxvcqRVd2wGXaJm8Cqz"
			+ "E0AhJzvU7DQQDf06R/566UOP9qOw7F1LjiPIsrQ/DjOVf7Ho7UOyl6TRI+qYv8/LYMDUSJFsUb4YpBKNgbmq01BJIc+QyYfAjzOuRiRWGCb034xKJ1NYa5fAgMBAAECgYEAm"
			+ "XvKh9xeSzH4AHw2j0ehA/ykH/2RhOu+NstjzNWF9MDqhOJfXM/hr/biqRP6Bl1gaIF5eVxCL79o0aFJYBBQsm/9nq241OitQFai8gItzViJPkgpOjZTuFMDynkibF8L3gaso"
			+ "+0dZOkSsGTscA6NebFp90s0vq00SINGHJ6J4OkCQQDs62rhimBbaXB6z8DrKTe+evwpv7cNhdbfX9XHZzLz28vsPqWs3cFqp5srNe9D5bI6QtrvJUg8rj8ykQypipS1AkEAu"
			+ "vrP+ve8y0I8TpV5yEhY31G1fsONiFAPkhTnKXyHNgNbGI1Ojc2pH1PUr74BCgHfwPT8FW829klWjI1bZI6XQwJAU8Dlh9XjOm2L1d6b1IY9rpjLi/a6P42Q6GZ4rIVO/eY1s"
			+ "M50wyehuJKHyD7I1rfcybvYqbIEV29B6B5e25CiAQJBALPg5oTCIFZKekn/cxFCyHzO1pQE/PvOSax3f4thyZIk2FZeWtwAplsFAu+vEsDV3LR8+qaEP5PgKes9clbi9pECQ"
			+ "QDbKoJhmIttm+ndY8LkuQf3f7tqrHyZZDUccAc3o7WOUtuQigIsyKf7nbi3nsU1Khjbgd6to/UTBMwdq9z+il+x";

}
