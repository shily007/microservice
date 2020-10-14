// 学校名称
const schoolName = "成都职业高级中学校";
// 民族
const nations = ["汉族", "壮族", "满族", "回族", "苗族", "维吾尔族", "土家族", "彝族", "蒙古族", "藏族", "布依族", "侗族", "瑶族", "朝鲜族", "白族", "哈尼族", "哈萨克族", "黎族", "傣族"
    , "畲族", "傈僳族", "仡佬族", "东乡族", "高山族", "拉祜族", "水族", "佤族", "纳西族", "羌族", "土族", "仫佬族", "锡伯族", "柯尔克孜族", "达斡尔族", "景颇族", "毛南族", "撒拉族", "布朗族"
    , "塔吉克族", " 阿昌族", " 普米族", " 鄂温克族", " 怒族", "京族", "基诺族", "德昂族", "保安族", "俄罗斯族", "裕固族", "乌孜别克族", " 门巴族", "鄂伦春族", " 独龙族", "塔塔尔族", "赫哲族"
    , "珞巴族"];
//验证码验证
const code = [
    { required: true, message: "验证码不能为空！", trigger: "blur" },
    {
        min: 6,
        max: 6,
        message: "请输入正确的6位验证码！",
        trigger: "blur",
    }
];
//手机号码验证
const phone = [
    { required: true, message: "手机号码不能为空！", trigger: "blur" },
    {
        min: 11,
        max: 11,
        message: "请输入正确的11位手机号码！",
        trigger: "blur",
    },
];
//姓名验证
const name = [
    { required: true, message: "请输入姓名", trigger: "blur" },
    { min: 2, max: 5, message: "长度在 2 到 5 个字符", trigger: "blur" }
];
//身份证号码验证
const idno = [
    { required: true, message: "请填写身份证号", trigger: "blur" },
    { min: 18, max: 18, message: "长度为18个字符", trigger: "blur" }
];
//性别验证
const gender = [{ required: true, message: "请选择性别", trigger: "change" }];
//民族验证
const nation = [{ required: true, message: "请选择民族", trigger: "change" }];
//输入框默认验证
const input_desc = [{ required: true, message: "请完善信息！", trigger: "blur" }];
//单选、复选、下拉默认验证
const select_desc = [{ required: true, message: "请选择！", trigger: "change" }];
//邮箱验证
const email = [{ required: true, message: "邮箱不能为空！", trigger: "blur" }];
//证件类型
const idTypes = ["居民身份证", "军官证", "士兵证", "文职干部证", "部队离退休证", "香港特区护照/身份证明", "澳门特区护照/身份证明", "台湾居民来往大陆通行证", "境外永久居住证", "护照", "其他"];
const headerShow = true;
//政治面貌
const politicalStatus = ["中国共产主义青年团团员", "群众", "中国共产党员", "中国共产党预备党员", "中国国民党革命委员会会员", "中国民主同盟盟员",
    "中国民主建国会会员", "中国民主促进会会员", "中国农工民主党党员", "中国致工党党员", "九三学社社员", "台湾民主自治同盟盟员", "无党派民主人士"];
//婚姻状况
const maritalStatus = ["未婚", "已婚"];
//国家
const countrys = ["中国", "其他国家"];
//港澳台侨外
const overseasChinese = ["非港澳台湾侨", "香港同胞", "香港同胞亲属", "澳门同胞", "澳门同胞亲属", "台湾同胞", "台湾同胞亲属", "华侨", "侨眷", "归侨", "归侨子女"
    , "归国留学人员", "非华裔中国人", "外籍华裔人", "外国人", "其他"];
//户口性质
const huKouXingZhi = ["农业户口", "非农业户口"];
//学生居住地类型
const habitationType = ["农村","县城","乡镇非农","城市"];
export default {
    schoolName, nations, code, phone, name, idno, gender, nation, input_desc, select_desc, email, idTypes, headerShow, politicalStatus,
    maritalStatus, countrys, overseasChinese, huKouXingZhi,habitationType
}