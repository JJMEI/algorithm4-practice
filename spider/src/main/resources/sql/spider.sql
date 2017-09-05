CREATE TABLE goods_info
(
  id INT(11) NOT NULL  AUTO_INCREMENT COMMENT 'ID',
  goods_id VARCHAR(225) NOT NULL  COMMENT '商品ID',
  goods_name VARCHAR(225) NOT NULL COMMENT '商品名称',
  image_url VARCHAR(225) NOT NULL  COMMENT '商品图片地址',
  goods_price VARCHAR(255) NOT NULL  COMMENT '商品价格',
  PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET =utf8 COMMENT ='商品信息表';


CREATE TABLE goods_comment
(
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
  goods_code VARCHAR(225) NOT NULL COMMENT '商品ID',
  commenter VARCHAR(225) NOT NULL COMMENT '评论人ID',
  comment   TEXT NOT NULL COMMENT '评论',
  FOREIGN KEY (goods_code) REFERENCES goods_info(goods_id)
)ENGINE = InnoDB DEFAULT CHARSET =utf8 COMMENT ='商品信息表';

ALTER TABLE goods_info MODIFY goods_id VARCHAR(225) UNIQUE ;

SELECT goods_price,goods_name FROM goods_info WHERE goods_name REGEXP ".乐视.";