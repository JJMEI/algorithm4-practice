/**
 *    Copyright 2009-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package cn.meijunjie.mybatissourcecode;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.io.Closeable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * The primary Java interface for working with MyBatis.
 * Through this interface you can execute commands, get mappers and manage transactions.
 *
 * @author Clinton Begin
 */
public interface SqlSession extends Closeable {


  <T> T selectOne(String statement);  //selectone 内部还是依赖selectlist实现的

  <T> T selectOne(String statement, Object parameter);


  <E> List<E> selectList(String statement);


  <E> List<E> selectList(String statement, Object parameter);


  <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds);


  <K, V> Map<K, V> selectMap(String statement, String mapKey);


  <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey);


  <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds);


  <T> Cursor<T> selectCursor(String statement);


  <T> Cursor<T> selectCursor(String statement, Object parameter);
  <T> Cursor<T> selectCursor(String statement, Object parameter, RowBounds rowBounds);


  void select(String statement, Object parameter, ResultHandler handler);


  void select(String statement, ResultHandler handler);


  void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler);


  int insert(String statement);


  int insert(String statement, Object parameter);


  int update(String statement);


  int update(String statement, Object parameter);


  int delete(String statement);


  int delete(String statement, Object parameter);


  void commit();


  void commit(boolean force);


  void rollback();


  void rollback(boolean force);


  List<BatchResult> flushStatements();

  @Override
  void close();

  /**
   * Clears local session cache
   */
  void clearCache();

  /**
   * Retrieves current configuration
   * @return Configuration
   */
  Configuration getConfiguration();

  /**
   * Retrieves a mapper.
   * @param <T> the mapper type
   * @param type Mapper interface class
   * @return a mapper bound to this SqlSession
   */
  <T> T getMapper(Class<T> type);

  /**
   * Retrieves inner database connection
   * @return Connection
   */
  Connection getConnection();
}
