CREATE TABLE goods_info
(
  id INT(11) NOT NULL  AUTO_INCREMENT COMMENT 'ID',
  goods_id VARCHAR(225) NOT NULL  COMMENT '商品ID',
  goods_name VARCHAR(225) NOT NULL COMMENT '商品名称',
  image_url VARCHAR(225) NOT NULL  COMMENT '商品图片地址',
  goods_price VARCHAR(255) NOT NULL  COMMENT '商品价格',
  PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET =utf8 COMMENT ='商品信息表'