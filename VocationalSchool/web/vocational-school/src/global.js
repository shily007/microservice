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
    { min: 2, max: 5, message: "长度在 2 到 5 个字符", trigger: "blur" },
];
//身份证号码验证
const idno = [
    { required: true, message: "请填写身份证号", trigger: "blur" },
    { min: 18, max: 18, message: "长度为18个字符", trigger: "blur" },
];
//性别验证
const gender = [{ required: true, message: "请选择性别", trigger: "change" }];
//民族验证
const nation = [{ required: true, message: "请选择民族", trigger: "change" }];
//输入框默认验证
const input_desc = [{ required: true, message: "请填写完善信息！", trigger: "blur" }];
//单选、复选、下拉默认验证
const select_desc = [{ required: true, message: "请选择！", trigger: "change" }];
//邮箱验证
const email = [{ required: true, message: "邮箱不能为空！", trigger: "blur" }];
export default {
    schoolName, nations, code, phone, idno, gender, nation, input_desc, select_desc, email
}