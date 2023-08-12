// Generated from //wsl$/Ubuntu-22.04/home/xzq/project/Mx_compiler/src/Parser\Mx.g4 by ANTLR 4.12.0
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(MxParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#mainFn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainFn(MxParser.MainFnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(MxParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#varDefUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefUnit(MxParser.VarDefUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#constructionFuncDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructionFuncDef(MxParser.ConstructionFuncDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classMember}
	 * labeled alternative in {@link MxParser#classComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMember(MxParser.ClassMemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constructionFunc}
	 * labeled alternative in {@link MxParser#classComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructionFunc(MxParser.ConstructionFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classMethod}
	 * labeled alternative in {@link MxParser#classComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMethod(MxParser.ClassMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(MxParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#funcCallArglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallArglist(MxParser.FuncCallArglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(MxParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(MxParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MxParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vardefStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardefStmt(MxParser.VardefStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MxParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vardefForStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardefForStmt(MxParser.VardefForStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprForStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprForStmt(MxParser.ExprForStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(MxParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(MxParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pureExprStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPureExprStmt(MxParser.PureExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStmt(MxParser.EmptyStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpr(MxParser.NewExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalNot}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalNot(MxParser.LogicalNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(MxParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preFixExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreFixExpr(MxParser.PreFixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(MxParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternaryConditional}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryConditional(MxParser.TernaryConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberVariableExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberVariableExpr(MxParser.MemberVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberFuncExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberFuncExpr(MxParser.MemberFuncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitwiseNot}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseNot(MxParser.BitwiseNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryPlus}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPlus(MxParser.UnaryPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(MxParser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryMinus}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinus(MxParser.UnaryMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(MxParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sufFixExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSufFixExpr(MxParser.SufFixExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(MxParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MxParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(MxParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleType}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleType(MxParser.SingleTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classType}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(MxParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newSingleArray}
	 * labeled alternative in {@link MxParser#newType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewSingleArray(MxParser.NewSingleArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newClassArray}
	 * labeled alternative in {@link MxParser#newType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewClassArray(MxParser.NewClassArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newClass}
	 * labeled alternative in {@link MxParser#newType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewClass(MxParser.NewClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#newArrayExprCount}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArrayExprCount(MxParser.NewArrayExprCountContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#newArrayEmptyCount}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArrayEmptyCount(MxParser.NewArrayEmptyCountContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#singleTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTypeName(MxParser.SingleTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(MxParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#logicalLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalLiteral(MxParser.LogicalLiteralContext ctx);
}