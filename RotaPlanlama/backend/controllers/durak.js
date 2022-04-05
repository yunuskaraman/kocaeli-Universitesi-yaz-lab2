const durak = require("../models/durak");

exports.postDurakAdd = async (req,res) => {
    try{
        const newDurak = new durak({
            durak_adi : req.body.durak_adi,
            lat:req.body.lat,
            lng:req.body.lng,
        });

        const savedDurak = newDurak.save();
        res.status(200).json(newDurak);
    }catch(err){
        res.status(500).json(err);
    }

}
