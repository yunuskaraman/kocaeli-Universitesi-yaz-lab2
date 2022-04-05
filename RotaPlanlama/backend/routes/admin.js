const  router = require('express').Router();
const userAdd = require("../controllers/admin");
const durakAdd = require("../controllers/durak");
const aracAdd = require("../controllers/arac");


router.post('/user-add',userAdd.postUserAdd);
router.post('/durak-add',durakAdd.postDurakAdd);
router.post('/arac-add',aracAdd.postArackAdd);
router.get('/',userAdd.getUserAdd);

module.exports = router;