const user = require("../models/admin");
const bcrypt = require('bcrypt');

exports.postUserAdd = async (req,res) => {
    try{
        const salt = await bcrypt.genSalt(10);
        const hashedPassword = await bcrypt.hash(req.body.sifre, salt);

        const newUser = new user({
            adi : req.body.adi,
            soyadi:req.body.soyadi,
            tel:req.body.tel,
            soyadi : req.body.email,
            sifre : hashedPassword,
        });

        const savedUser = newUser.save();
        res.status(200).json(savedUser);
    }catch(err){
        res.status(500).json(err);
    }

}

exports.getUserAdd = async (req,res) => {
   
    res.send("/");

}